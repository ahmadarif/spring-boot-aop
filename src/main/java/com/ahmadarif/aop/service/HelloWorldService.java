package com.ahmadarif.aop.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ARIF on 10-Mar-17.
 */
@Component
public class HelloWorldService {

    @Value("${name:World}")
    private String name = "tes";

    public void setName(String name) {
        this.name = name;
    }

    public String getHelloMessage() {
        return "Hello " + this.name;
    }

}