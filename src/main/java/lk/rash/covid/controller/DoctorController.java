package lk.rash.covid.controller;

import lk.rash.covid.dto.DoctorDto;
import lk.rash.covid.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/doctor")
public class DoctorController {
    @Autowired
    DoctorService service;

    @PostMapping("/register")
    public ResponseEntity saveDoctor(@RequestBody DoctorDto doctorDto){
        service.save(doctorDto);
        return new ResponseEntity("Done", HttpStatus.OK);
    }

}
