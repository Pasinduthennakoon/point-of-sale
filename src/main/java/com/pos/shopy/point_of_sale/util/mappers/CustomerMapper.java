package com.pos.shopy.point_of_sale.util.mappers;

import com.pos.shopy.point_of_sale.dto.CustomerDTO;
import com.pos.shopy.point_of_sale.dto.response.ResponseActiveCustomerNameAndNumberDto;
import com.pos.shopy.point_of_sale.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO entityToDto(Customer customer);
    List<CustomerDTO> entityListToDtoList(List<Customer> customer);
    List<ResponseActiveCustomerNameAndNumberDto> entityListToDtoListOnlyNameAndNumber(List<Customer> customer);
}
