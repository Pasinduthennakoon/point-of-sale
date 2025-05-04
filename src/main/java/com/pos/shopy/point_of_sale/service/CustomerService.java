package com.pos.shopy.point_of_sale.service;

import com.pos.shopy.point_of_sale.dto.CustomerDTO;
import com.pos.shopy.point_of_sale.dto.request.CustomerSaveRequestDTO;

public interface CustomerService {

    public String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO);

}
