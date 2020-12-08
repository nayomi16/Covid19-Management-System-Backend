package lk.rash.covid.controller;

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

    @PutMapping
    public ResponseEntity updatePatient(@RequestBody PatientUpdateDto updateDto){
        Boolean isUpdated = service.updatePatient(updateDto.getPatient_id(), updateDto.getSeverity_level(), updateDto.getAdmite_date(), updateDto.getAdmitted_by());
        return new ResponseEntity(new StandardResponse(200,"updated",isUpdated),HttpStatus.OK);
    }


}
