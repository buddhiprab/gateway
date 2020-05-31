package com.api.service3.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*created by Buddhi*/

@RestController
public class ServiceController {

    @PatchMapping("/test3/misc")
    public ResponseEntity test() {
        return new ResponseEntity("/service3/test3", HttpStatus.OK);
    }

}
