package com.pos.shopy.point_of_sale.controller;

import com.pos.shopy.point_of_sale.dto.CustomerDTO;
import com.pos.shopy.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.shopy.point_of_sale.dto.request.CustomerUpdateRequestDTO;
import com.pos.shopy.point_of_sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerContraoller {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerSaveRequestDTO customerSaveRequestDTO) {
        String id = customerService.addCustomer(customerSaveRequestDTO);

        return id;
    }

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateRequestDTO customerUpdateRequestDTO) {
        String state = customerService.updateCustomer(customerUpdateRequestDTO);
        return state;
    }

    //    request paramiter
    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int id) {
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        return customerDTO;
    }

    @GetMapping(
            path = "/get-all-customers"
    )
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    //    path variables
    @DeleteMapping(
            path = {"/delete-customer/{id}"}
    )
    public boolean deleteCustomer(@PathVariable(value = "id") int id) {
        boolean deletedCustomer = customerService.deleteCustomer(id);
        return deletedCustomer;

    }

    @GetMapping(
            path = {"/get-by-name"},
            params = "name"
    )
    public List<CustomerDTO> getCustomersByName(@RequestParam(value = "name")String name){
        List<CustomerDTO> customers = customerService.getCustomersByName(name);
        return customers;
    }


}
