package com.api.service2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*created by Buddhi*/

@RestController
public class ServiceController {

    @PostMapping("/test2")
    public ResponseEntity test() {
        return new ResponseEntity("/service2/test2", HttpStatus.OK);
    }

}
