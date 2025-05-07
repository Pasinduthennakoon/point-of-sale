package com.pos.shopy.point_of_sale.service;

import com.pos.shopy.point_of_sale.dto.CustomerDTO;
import com.pos.shopy.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.shopy.point_of_sale.dto.request.CustomerUpdateQuaryRequestDTO;
import com.pos.shopy.point_of_sale.dto.request.CustomerUpdateRequestDTO;
import com.pos.shopy.point_of_sale.dto.response.ResponseActiveCustomerNameAndNumberDto;

import java.util.List;

public interface CustomerService {

    public String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO);

    String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO);

    CustomerDTO getCustomerById(int id);

    List<CustomerDTO> getAllCustomers();

    boolean deleteCustomer(int id);

    List<CustomerDTO> getCustomersByName(String name);

    List<CustomerDTO> getAllCustomersByActiveState() throws Exception;

    List<ResponseActiveCustomerNameAndNumberDto> getAllCustomersByActiveStateOnlyNameAndNumber() throws Exception;

    String updateCustomerQuary(CustomerUpdateQuaryRequestDTO customerUpdateQuaryRequestDTO, int id);

}
