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
@RequestMapping("api/v1/moh")
public class MohController {

    @Autowired
    HospitalService hospitalService;

    @PostMapping("/addHospital")
    public ResponseEntity addHospital(@RequestBody HospitalDto hospitalDto){
        hospitalService.add(hospitalDto);
        return new ResponseEntity("done", HttpStatus.OK);
    }



}
