package com.pos.shopy.point_of_sale.controller;

import com.pos.shopy.point_of_sale.dto.CustomerDTO;
import com.pos.shopy.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.shopy.point_of_sale.dto.request.CustomerUpdateQuaryRequestDTO;
import com.pos.shopy.point_of_sale.dto.request.CustomerUpdateRequestDTO;
import com.pos.shopy.point_of_sale.dto.request.CustomerUpdateTwoRequestDTO;
import com.pos.shopy.point_of_sale.dto.response.ResponseActiveCustomerNameAndNumberDto;
import com.pos.shopy.point_of_sale.dto.response.ResponseCustomerIdDTO;
import com.pos.shopy.point_of_sale.service.CustomerService;
import com.pos.shopy.point_of_sale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

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
    public List<CustomerDTO> getCustomersByName(@RequestParam(value = "name") String name) {
        List<CustomerDTO> customers = customerService.getCustomersByName(name);
        return customers;
    }

    @GetMapping(
            path = {"/get-by-active-state/{state}"}
    )
    public List<CustomerDTO> getCustomersByActiveState(@PathVariable(value = "state") String state) throws Exception {
        if (state.equalsIgnoreCase("active") | state.equalsIgnoreCase("inactive")) {
            boolean status = state.equalsIgnoreCase("active") ? true : false;
            List<CustomerDTO> customerDTOS = customerService.getAllCustomersByActiveState(status);
            return customerDTOS;

        } else {
            List<CustomerDTO> customerDTOS = customerService.getAllCustomers();
            return customerDTOS;
        }
    }

    @GetMapping(
            path = {"/get-by-active-state-name-and-number"}
    )
    public List<ResponseActiveCustomerNameAndNumberDto> getCustomersByActiveStateOnlyNameAndNumber() throws Exception {
        List<ResponseActiveCustomerNameAndNumberDto> customerDTOS = customerService.getAllCustomersByActiveStateOnlyNameAndNumber();
        return customerDTOS;

    }

    @PutMapping(
            path = "/update-quary/{id}"
    )
    public String updateCustomer(
            @RequestBody CustomerUpdateQuaryRequestDTO customerUpdateQuaryRequestDTO,
            @PathVariable(value = "id") int id) {
        String state = customerService.updateCustomerQuary(customerUpdateQuaryRequestDTO, id);
        return state;
    }

    @GetMapping(
            path = {"/get-customer-by-nic"},
            params = {"nic"}
    )
    public CustomerDTO getCustomerByNic(@RequestParam(value = "nic") String nic) {
        CustomerDTO customerDTO = customerService.getCustomerByNic(nic);
        return customerDTO;
    }

    @GetMapping(
            path = {"/get-customer-by-id"},
            params = {"id"}
    )
    public ResponseCustomerIdDTO searchCustomerById(@RequestParam(value = "id") int id) throws Exception {
        ResponseCustomerIdDTO responseCustomerNicDTO = customerService.searchCustomerByid(id);
        return responseCustomerNicDTO;
    }

    @PutMapping(
            path = {"/update-name-salary"},
            params = {"id"}
    )
    public String updateCustomerSpecCols(
            @RequestBody CustomerUpdateTwoRequestDTO customerUpdateTwoRequestDTO,
            @RequestParam(value = "id") int id) throws Exception {
        String state = customerService.updateCustomerSpecCols(customerUpdateTwoRequestDTO, id);
        return state;
    }

    @GetMapping(
            path = {"/get-custom-count-by-state"},
            params = {"state"} //frontend can pass to state only "active","inactive" and "all"
    )
    public ResponseEntity<StandardResponse> getAllCustomerCountByState(@RequestParam(value = "state") String state) {
        long customercout = 0;
        if (state.equalsIgnoreCase("active") | state.equalsIgnoreCase("inactive")) {

            boolean status = state.equalsIgnoreCase("active") ? true : false;
            customercout = customerService.countCustomerByActiveState(status);

        } else {
            customercout = customerService.countAllCustomers();
        }
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "customer count", customercout),
                HttpStatus.OK
        );
    }

}
