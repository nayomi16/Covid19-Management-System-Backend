package lk.rash.covid.controller;

import lk.rash.covid.dto.PatientCount;
import lk.rash.covid.dto.PatientDto;
import lk.rash.covid.response.StandardResponse;
import lk.rash.covid.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {
    @Autowired
    PatientService service;
    @Autowired
    PatientCount patientCount;

    @PostMapping("/register")
    public ResponseEntity registerPatient(@RequestBody PatientDto patientDto){
        service.save(patientDto);

        return new ResponseEntity("Done", HttpStatus.OK);
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



}
