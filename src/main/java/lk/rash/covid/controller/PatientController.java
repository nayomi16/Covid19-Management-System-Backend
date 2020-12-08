package lk.rash.covid.controller;

import lk.rash.covid.dto.HospitalPatient;
import lk.rash.covid.dto.PatientCount;
import lk.rash.covid.dto.PatientDto;
import lk.rash.covid.dto.PatientUpdateDto;
import lk.rash.covid.entity.Patient;
import lk.rash.covid.response.PatientResponse;
import lk.rash.covid.response.StandardResponse;
import lk.rash.covid.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {
    @Autowired
    PatientService service;
    @Autowired
    PatientCount patientCount;

    @PostMapping("/register")
    public ResponseEntity registerPatient(@RequestBody PatientDto patientDto) throws SQLException, ClassNotFoundException {
        PatientResponse patientResponse = service.save(patientDto);

        return new ResponseEntity(new StandardResponse(200,"true",patientResponse), HttpStatus.OK);
    }



    @GetMapping("/totalcount")
    public ResponseEntity getTotalCount(){
        patientCount.setActivecount(service.activeCasesCount());
        patientCount.setDischarged(service.dischargedCasesCount());
        return new ResponseEntity(new StandardResponse(200,"ll",patientCount),HttpStatus.OK);
    }

//    @GetMapping("/register")
//    public ResponseEntity getPatientCount(){
//        service.getPatientCount();
//        return new ResponseEntity("ok",HttpStatus.OK);
//
//    }

    @GetMapping("/id")
    public ResponseEntity getPatient(@RequestParam String patientId){
        PatientDto patient=service.getPatient(patientId);
        return new ResponseEntity(new StandardResponse(200,"ll",patient),HttpStatus.OK);
    }

    @GetMapping("/hospitalPatientCount")
    public ResponseEntity getPatientCount(){
        List<HospitalPatient> patients=service.getPatientCount();
        return new ResponseEntity(new StandardResponse(200,"ll",patients),HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity getAllPatients(){
        List<PatientDto> AllPatients=service.getAllPatients();
        return new ResponseEntity(new StandardResponse(200,"ll",AllPatients),HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity updatePatient(@RequestBody PatientUpdateDto updateDto){
        Boolean isUpdated = service.updatePatient(updateDto.getPatientId(),updateDto.getDoctorId(), updateDto.getSeverityLevel(), updateDto.getDate(), updateDto.getRole());
        return new ResponseEntity(new StandardResponse(200,"updated",isUpdated),HttpStatus.OK);
    }


}
