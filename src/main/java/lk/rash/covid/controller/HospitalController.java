package lk.rash.covid.controller;

import lk.rash.covid.dto.HospitalDto;
import lk.rash.covid.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/hospital")
public class HospitalController {

    @Autowired
    HospitalService service;

    @PostMapping("/add")
    public ResponseEntity addHospital(@RequestBody HospitalDto hospitalDto){
        service.add(hospitalDto);
        return new ResponseEntity("done", HttpStatus.OK);
    }
}
