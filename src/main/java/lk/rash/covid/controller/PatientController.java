package lk.rash.covid.controller;

import lk.rash.covid.dto.PatientDto;
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

    @PostMapping("/register")
    public ResponseEntity registerPatient(@RequestBody PatientDto patientDto){
        service.save(patientDto);
        return new ResponseEntity("Done", HttpStatus.OK);

    }

    @GetMapping
    public String test(){
        return "test ok";
    }


}
