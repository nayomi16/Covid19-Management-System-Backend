package lk.rash.covid.controller;

import lk.rash.covid.dto.DoctorDto;
import lk.rash.covid.dto.DoctorHosDto;
import lk.rash.covid.response.HospitaBedResponse;
import lk.rash.covid.response.StandardResponse;
import lk.rash.covid.service.DoctorService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/doctor")
public class DoctorController {
    @Autowired
    DoctorService service;

//    @PostMapping("/register")
//    public ResponseEntity saveDoctor(@RequestBody DoctorDto doctorDto){
//        service.save(doctorDto);
//        return new ResponseEntity("Done", HttpStatus.OK);
//    }

    @GetMapping("/check")
    public ResponseEntity isDirector(@RequestParam String username){
        boolean director = service.isDirector(username);
        return new ResponseEntity(new StandardResponse(200,"done",director),HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity hospitalBedList(@RequestParam String username){
        HospitaBedResponse bedResponse = service.getBedList(username);
        return new ResponseEntity(new StandardResponse(200,"done",bedResponse),HttpStatus.OK);
    }

    @GetMapping("/hospitalDetails")
    public ResponseEntity hospitalDetails(@RequestParam String hospitalId){
        List<DoctorHosDto> docters = service.getDocters(hospitalId);
        return new ResponseEntity(new StandardResponse(200,"done",docters),HttpStatus.OK);
    }

    @GetMapping("/allDoctors")
    public ResponseEntity getAllDoctors(){
        List<DoctorHosDto> allDocters = service.getAllDocters();
        return new ResponseEntity(new StandardResponse(200,"done",allDocters),HttpStatus.OK);
    }

}
