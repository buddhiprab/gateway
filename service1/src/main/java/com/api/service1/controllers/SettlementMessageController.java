package com.api.service1.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*created by Buddhi*/

@RestController
@RequestMapping("/service1")
public class SettlementMessageController {

    @GetMapping("/test")
    public ResponseEntity test() {
        return new ResponseEntity("/service1/test", HttpStatus.OK);
    }

}
