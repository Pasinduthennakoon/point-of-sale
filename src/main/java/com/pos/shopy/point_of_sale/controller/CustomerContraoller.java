package com.pos.shopy.point_of_sale.controller;

import com.pos.shopy.point_of_sale.dto.CustomerDTO;
import com.pos.shopy.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.shopy.point_of_sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerContraoller {

    @Autowired
    private CustomerService customerService;

//    @GetMapping(path = "/get-1")
//    public String getCustomer1(){
//        String customer = "Customer 1";
//        System.out.println(customer);
//        return customer;
//
//    }
//
//    @GetMapping(path = "/get-2")
//    public String getCustomer2(){
//        String customer = "Customer 2";
//        System.out.println(customer);
//        return customer;
//    }

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerSaveRequestDTO customerSaveRequestDTO){
        String id = customerService.addCustomer(customerSaveRequestDTO);

        return id;
    }
}
