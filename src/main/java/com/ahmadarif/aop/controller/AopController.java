package com.ahmadarif.aop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * Created by ARIF on 11-Mar-17.
 */
@RestController
public class AopController {

    @RequestMapping("/")
    public ResponseEntity<Map> halo() {
        return ResponseEntity.ok(Collections.singletonMap("halo", "Ahmad Arif"));
    }

}