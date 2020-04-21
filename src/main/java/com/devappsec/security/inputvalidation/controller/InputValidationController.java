package com.devappsec.security.inputvalidation.controller;

import com.devappsec.security.inputvalidation.model.InputValidationModel;
import com.devappsec.security.inputvalidation.service.InputValidationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InputValidationController {

    @Autowired
    private InputValidationServiceImpl inputValidationService;

    @GetMapping("/health")
    public String index() {
        return "Up!";
    }

    @PostMapping(value = "/validates", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> validateMany(@RequestBody InputValidationModel[] requestInputValidationModel) throws Exception{

        int isNotSafeCounter = 0;

        if(requestInputValidationModel == null) {
            return ResponseEntity.noContent().build();
        }

        for(InputValidationModel singleInput : requestInputValidationModel) {
            if(!inputValidationService.validateInput(singleInput)) {
                isNotSafeCounter += 1;
            }
        }

        if(isNotSafeCounter == 0) {
            return new ResponseEntity("Safe", HttpStatus.OK);
        } else {
            return new ResponseEntity("Not safe",HttpStatus.NOT_FOUND);
        }

    }
}