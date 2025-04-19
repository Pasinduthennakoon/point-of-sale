package com.pos.shopy.point_of_sale.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerContraoller {

    @GetMapping(path = "/get-1")
    public String getCustomer1(){
        String customer = "Customer 1";
        System.out.println(customer);
        return customer;

    }

    @GetMapping(path = "/get-2")
    public String getCustomer2(){
        String customer = "Customer 2";
        System.out.println(customer);
        return customer;
    }
}
