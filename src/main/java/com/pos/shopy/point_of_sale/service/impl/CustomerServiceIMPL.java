package com.pos.shopy.point_of_sale.service.impl;

import com.pos.shopy.point_of_sale.dto.CustomerDTO;
import com.pos.shopy.point_of_sale.entity.Customer;
import com.pos.shopy.point_of_sale.repo.CustomerRepo;
import com.pos.shopy.point_of_sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String addCustomer(CustomerDTO customerDTO) {

        Customer customer = new Customer(
               customerDTO.getCustomerId(),
               customerDTO.getCustomerName(),
               customerDTO.getCustomerAddress(),
               customerDTO.getCustomerSalary(),
               customerDTO.getContactNumbers(),
               customerDTO.getNic(),
               customerDTO.isActiveState()
        );
        customerRepo.save(customer);

        return customerDTO.getCustomerName() + " Saved!";
    }
}
