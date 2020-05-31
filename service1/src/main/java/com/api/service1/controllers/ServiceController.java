package com.api.service1.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*created by Buddhi*/

@RestController
public class ServiceController {

    @GetMapping("/test1")
    public ResponseEntity test(@RequestParam(name = "param1") String param1) {
        return new ResponseEntity("/service1/test1?param1="+param1, HttpStatus.OK);
    }

}
