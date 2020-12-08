package lk.rash.covid.controller;

import lk.rash.covid.dto.HospitalCount;
import lk.rash.covid.dto.HospitalDto;
import lk.rash.covid.entity.PatientQueue;
import lk.rash.covid.response.StandardResponse;
import lk.rash.covid.service.MohService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/moh")
public class MohController {

    @Autowired
    MohService mohService;



    @PostMapping("/addHospital")
    public ResponseEntity addHospital(@RequestBody HospitalDto hospitalDto){
        mohService.add(hospitalDto);
        return new ResponseEntity("done", HttpStatus.OK);
    }

    @GetMapping("/queue")
    public ResponseEntity getQueueDetails(){
        List<PatientQueue> queueDetails = mohService.getQueueDetails();
        return new ResponseEntity(new StandardResponse(200,"done",queueDetails),HttpStatus.OK);
    }

    @GetMapping("/beds")
    public ResponseEntity getBedDetails(){
        List<HospitalCount> queueDetails = mohService.getBedDetails();
        return new ResponseEntity(new StandardResponse(200,"done",queueDetails),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateQueue(@RequestParam String hospitalId){
        boolean updateQueue = mohService.updateQueue(hospitalId);
        return new ResponseEntity(new StandardResponse(200,"done",updateQueue),HttpStatus.OK);
    }





}
