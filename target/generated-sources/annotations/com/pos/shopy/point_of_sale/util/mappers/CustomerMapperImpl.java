package com.pos.shopy.point_of_sale.util.mappers;

import com.pos.shopy.point_of_sale.dto.CustomerDTO;
import com.pos.shopy.point_of_sale.dto.response.ResponseActiveCustomerNameAndNumberDto;
import com.pos.shopy.point_of_sale.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-07T10:21:48+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO entityToDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setCustomerId( customer.getCustomerId() );
        customerDTO.setCustomerName( customer.getCustomerName() );
        customerDTO.setCustomerAddress( customer.getCustomerAddress() );
        customerDTO.setCustomerSalary( customer.getCustomerSalary() );
        List<String> list = customer.getContactNumbers();
        if ( list != null ) {
            customerDTO.setContactNumbers( new ArrayList<String>( list ) );
        }
        customerDTO.setNic( customer.getNic() );
        customerDTO.setActiveState( customer.isActiveState() );

        return customerDTO;
    }

    @Override
    public List<CustomerDTO> entityListToDtoList(List<Customer> customer) {
        if ( customer == null ) {
            return null;
        }

        List<CustomerDTO> list = new ArrayList<CustomerDTO>( customer.size() );
        for ( Customer customer1 : customer ) {
            list.add( entityToDto( customer1 ) );
        }

        return list;
    }

    @Override
    public List<ResponseActiveCustomerNameAndNumberDto> entityListToDtoListOnlyNameAndNumber(List<Customer> customer) {
        if ( customer == null ) {
            return null;
        }

        List<ResponseActiveCustomerNameAndNumberDto> list = new ArrayList<ResponseActiveCustomerNameAndNumberDto>( customer.size() );
        for ( Customer customer1 : customer ) {
            list.add( customerToResponseActiveCustomerNameAndNumberDto( customer1 ) );
        }

        return list;
    }

    protected ResponseActiveCustomerNameAndNumberDto customerToResponseActiveCustomerNameAndNumberDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        ResponseActiveCustomerNameAndNumberDto responseActiveCustomerNameAndNumberDto = new ResponseActiveCustomerNameAndNumberDto();

        responseActiveCustomerNameAndNumberDto.setCustomerName( customer.getCustomerName() );
        List<String> list = customer.getContactNumbers();
        if ( list != null ) {
            responseActiveCustomerNameAndNumberDto.setContactNumbers( new ArrayList<String>( list ) );
        }

        return responseActiveCustomerNameAndNumberDto;
    }
}
