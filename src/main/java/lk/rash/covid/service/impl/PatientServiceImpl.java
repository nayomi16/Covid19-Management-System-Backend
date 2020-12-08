package lk.rash.covid.service.impl;

import lk.rash.covid.dto.HospitalPatient;
import lk.rash.covid.dto.PatientDto;
import lk.rash.covid.entity.Hospital;
import lk.rash.covid.entity.HospitalBed;
import lk.rash.covid.entity.PK.HospitalBedPK;
import lk.rash.covid.entity.Patient;
import lk.rash.covid.entity.PatientQueue;
import lk.rash.covid.repository.HospitalBedRepository;
import lk.rash.covid.repository.HospitalRepository;
import lk.rash.covid.repository.PatientQueueRepository;
import lk.rash.covid.repository.PatientRepository;
import lk.rash.covid.response.PatientResponse;
import lk.rash.covid.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.*;


@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository repository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    HospitalBedRepository hospitalBedRepository;
    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    PatientQueueRepository patientQueueRepository;

    @Override
    public PatientResponse save(PatientDto patientDto) throws SQLException, ClassNotFoundException{


        List<String> availableHospitals=new ArrayList<>();
        availableHospitals=hospitalBedRepository.BedsAvailableHospitals();
        int patient_location_x=patientDto.getLocation_x();
        int patient_location_y=patientDto.getLocation_y();
        double minimumDistance = 0.0;
        String finalHid = "";
        String finalHname = "";
        int queueNo = 0;
        ArrayList<Hospital> hospitalDetails = new ArrayList<>();

        if(patient_location_x<=600 && patient_location_y<=600){
            String patientId = idGenerator(patientDto.getFirst_name());
            patientDto.setId(patientId);
            Patient patient1 = modelMapper.map(patientDto, Patient.class);
            repository.save(patient1);

            if (!availableHospitals.isEmpty()) {
                for (String Hos_id : availableHospitals) {
                    hospitalDetails.add(hospitalRepository.getHospital(Hos_id));
                }
                for (Hospital hospital : hospitalDetails) {

                    double distance = distanceToHospital(hospital.getLocation_x(), hospital.getLocation_y(), patient_location_x, patient_location_y);

                    if (minimumDistance == 0.0) {
                        minimumDistance = distance;
                        finalHid = hospital.getId();
                        finalHname = hospital.getName();
                    } else {
                        if (minimumDistance > distance) {
                            minimumDistance = distance;
                            finalHid = hospital.getId();
                            finalHname = hospital.getName();
                        }
                    }
                }

                int bedId = hospitalBedRepository.getBedId(finalHid);
                HospitalBedPK hospitalBedPK=new HospitalBedPK(bedId,finalHid);
//                Patient patient2=repository.findById(patientId).get();
                HospitalBed hospitalBed=new HospitalBed(hospitalBedPK,patient1);
                hospitalBedRepository.save(hospitalBed);

                return new PatientResponse(patientId, bedId, finalHname, 0);

            }else{
                Optional<Patient> patient = repository.findById(patient1.getId());
                System.out.println(patient.get().getId());
                PatientQueue patientQueue=new PatientQueue(patient.get());
                PatientQueue queue = patientQueueRepository.save(patientQueue);
                if (queue!=null) {
                    queueNo = patientQueueRepository.getQueueNo(patientId);
                }
                return new PatientResponse(patientId, 0, finalHname, queueNo);

            }



        }else
        return null;
    }

    public double distanceToHospital(int hospitalX, int hospitalY, int patientX, int patientY){
        return Math.sqrt((hospitalX - patientX) * (hospitalX - patientX) +
                (hospitalY - patientY) * (hospitalY - patientY));
    }

    public String idGenerator(String firstName) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String randomstring = "1234";
        for (int i = 0; i < 3; i++) {
            sb.append(randomstring.charAt(random.nextInt(randomstring.length())));
        }
        String randomId = "Pid" + sb.toString() + firstName.substring(0, 3);
        return randomId;
    }
    @Override
    public int activeCasesCount() {
        repository.getActiveCases();

        return repository.getActiveCases();
    }

    @Override
    public int dischargedCasesCount() {
        return repository.getDischargedCases();
    }

    @Override
    public Boolean updatePatient(String patientId, String doctorId, String severity_level, Date date, String role) {
        int i=0;
        if(role.equals("admit")) {
             i=repository.upadatePatient(patientId,doctorId, severity_level, date);

        }
        else if(role.equals("discharge")){
//            System.out.println("kkkkkkkkkkkkkkk");
            i=repository.upadatePatientDis(patientId,doctorId,date);

        }
        System.out.println(i+"iiiiiii");
        if (i > 0) return true;
        else return false;
    }

    @Override
    public PatientDto getPatient(String patientId) {
        Patient patient = repository.findById(patientId).get();
        PatientDto patientDto = modelMapper.map(patient, PatientDto.class);
        return patientDto;
    }

    @Override
    public List<HospitalPatient> getPatientCount() {
        List<HospitalPatient> hospitalPatients=new ArrayList<>();
        List<Hospital> hospitals = hospitalRepository.findAll();
        for (Hospital h:hospitals) {
            int patients=10-hospitalBedRepository.bedCount(h.getId());
            HospitalPatient patient=new HospitalPatient(h.getId(),h.getName(),h.getDistrict(),patients);
            hospitalPatients.add(patient);
        }

        return hospitalPatients;
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<PatientDto> patientDtos=new ArrayList<>();
        List<Patient> all = repository.findAll();
        for (Patient patient:all) {
            PatientDto dto = modelMapper.map(patient, PatientDto.class);
            patientDtos.add(dto);
        }
        return patientDtos;
    }

//    @Override
//    public void getPatientCount() {
//        repository.getPatientCount();
//    }

}