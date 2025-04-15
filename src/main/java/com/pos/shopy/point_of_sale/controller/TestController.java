package com.pos.shopy.point_of_sale.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test")
@CrossOrigin
public class TestController {

    @GetMapping(path = "/get-1")
    public String getMyText1(){
        String myText = "This is my first spring boot project";
        System.out.println(myText);
        return myText;
    }

    @GetMapping(path = "get-2")
    public String getMyText2(){
        String myText = "This is my second spring boot project";
        System.out.println(myText);
        return myText;
    }
}
