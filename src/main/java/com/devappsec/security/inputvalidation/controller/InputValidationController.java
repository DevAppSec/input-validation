package com.devappsec.security.inputvalidation.controller;

import com.devappsec.security.inputvalidation.model.InputValidationModel;
import com.devappsec.security.inputvalidation.service.InputValidationServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
        int currentIndex = 0;
        ArrayList<Integer> indexWithError = new ArrayList<Integer>();

        if(requestInputValidationModel == null) {
            return ResponseEntity.noContent().build();
        }

        for(InputValidationModel singleInput : requestInputValidationModel) {
            currentIndex += 1;
            if(!inputValidationService.validateInput(singleInput)) {
                indexWithError.add(currentIndex);
                isNotSafeCounter += 1;
            }
        }

        if(isNotSafeCounter == 0) {
            JSONObject responseObj = new JSONObject();

            responseObj.put("title", "OK");
            responseObj.put("status", 200);

            return new ResponseEntity(responseObj.toString(), HttpStatus.OK);
        } else {
            JSONObject responseObj = new JSONObject();

            responseObj.put("title", "Bad Request");
            responseObj.put("status", 400);
            responseObj.put("type", "/validates");
            responseObj.put("invalidFields", "Unsafe value for the type in position "+ indexWithError.toString() +".");

            return new ResponseEntity(responseObj.toString(),HttpStatus.BAD_REQUEST);
        }

    }
}