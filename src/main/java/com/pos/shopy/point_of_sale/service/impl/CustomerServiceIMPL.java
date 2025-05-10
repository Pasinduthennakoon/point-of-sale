package com.pos.shopy.point_of_sale.service.impl;

import com.pos.shopy.point_of_sale.dto.CustomerDTO;
import com.pos.shopy.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.shopy.point_of_sale.dto.request.CustomerUpdateQuaryRequestDTO;
import com.pos.shopy.point_of_sale.dto.request.CustomerUpdateRequestDTO;
import com.pos.shopy.point_of_sale.dto.request.CustomerUpdateTwoRequestDTO;
import com.pos.shopy.point_of_sale.dto.response.ResponseActiveCustomerNameAndNumberDto;
import com.pos.shopy.point_of_sale.dto.response.ResponseCustomerIdDTO;
import com.pos.shopy.point_of_sale.entity.Customer;
import com.pos.shopy.point_of_sale.exception.NotFoundException;
import com.pos.shopy.point_of_sale.repo.CustomerRepo;
import com.pos.shopy.point_of_sale.service.CustomerService;
import com.pos.shopy.point_of_sale.util.mappers.CustomerMapper;
import jakarta.el.PropertyNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO) {

        //without id .because it is auto genarates by the entity
        Customer customer = new Customer(
                customerSaveRequestDTO.getCustomerName(),
                customerSaveRequestDTO.getCustomerAddress(),
                customerSaveRequestDTO.getCustomerSalary(),
                customerSaveRequestDTO.getContactNumbers(),
                customerSaveRequestDTO.getNic(),
                false
        );

        if (!customerRepo.existsById(customer.getCustomerId())) {
            customerRepo.save(customer);
            return customer.getCustomerName() + " Saved!";
        } else {
            return "Id is already exists";
        }

    }

    @Override
    public String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO) {
        if (customerRepo.existsById(customerUpdateRequestDTO.getCustomerId())) {
            Customer customer = customerRepo.getReferenceById(customerUpdateRequestDTO.getCustomerId());

            customer.setCustomerName(customerUpdateRequestDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateRequestDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateRequestDTO.getCustomerSalary());
            customer.setContactNumbers(customerUpdateRequestDTO.getContactNumbers());
            customer.setNic(customerUpdateRequestDTO.getNic());
            customer.setActiveState(customerUpdateRequestDTO.isActiveState());

            customerRepo.save(customer);
            return customer.getCustomerName() + " Updated";
        } else {
            System.out.println("that customer no longer in the database");
            return "that customer no longer in the database";
        }

    }

    @Override
    public CustomerDTO getCustomerById(int id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
//            CustomerDTO customerDTO = new CustomerDTO(
//                    customer.get().getCustomerId(),
//                    customer.get().getCustomerName(),
//                    customer.get().getCustomerAddress(),
//                    customer.get().getCustomerSalary(),
//                    customer.get().getContactNumbers(),
//                    customer.get().getNic(),
//                    customer.get().isActiveState()
//            );
//
//            return customerDTO;
//            CustomerDTO customerDTO = modelMapper.map(customer.get(), CustomerDTO.class);
            CustomerDTO customerDTO = customerMapper.entityToDto(customer.get()); /*mapstruct*/
            return customerDTO;
        } else {
            return null;
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getCustomers = customerRepo.findAll();

//        List<CustomerDTO> customerDTOList = new ArrayList<>();

//        for (Customer c : getCustomers) {
//            CustomerDTO customerDTO = new CustomerDTO(
//                    c.getCustomerId(),
//                    c.getCustomerName(),
//                    c.getCustomerAddress(),
//                    c.getCustomerSalary(),
//                    c.getContactNumbers(),
//                    c.getNic(),
//                    c.isActiveState()
//            );
//            customerDTOList.add(customerDTO);
//        }

//        List<CustomerDTO> customerDTOS = modelMapper.map(getCustomers,new TypeToken<List<CustomerDTO>>(){}.getType());

        List<CustomerDTO> customerDTOS = customerMapper.entityListToDtoList(getCustomers); /*mapstruct*/
        return customerDTOS;
    }

    @Override
    public boolean deleteCustomer(int id){
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);
        }else {
            throw new PropertyNotFoundException("Not found customer for this id");
        }
        return true;
    }

    @Override
    public List<CustomerDTO> getCustomersByName(String name) {
        List<Customer> customers = customerRepo.findAllByCustomerNameEquals(name);
        if(customers.size() > 0){
            List<CustomerDTO> customerDTOS = modelMapper.map(customers,new TypeToken<List<CustomerDTO>>(){}.getType());
            return customerDTOS;
        }else{
            throw new PropertyNotFoundException("no resualt");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean status) throws Exception {
        List<Customer> customers = customerRepo.findAllByActiveStateEquals(status);
        if(customers.size() > 0){
            List<CustomerDTO> getcustomers = customerMapper.entityListToDtoList(customers);
            return getcustomers;
        }else{
            throw new Exception("Active customers not found");
        }
    }

    @Override
    public List<ResponseActiveCustomerNameAndNumberDto> getAllCustomersByActiveStateOnlyNameAndNumber() throws Exception {
        List<Customer> customers = customerRepo.findAllByActiveStateEquals(true);
        if(customers.size() > 0){
            List<ResponseActiveCustomerNameAndNumberDto> getcustomers = customerMapper.entityListToDtoListOnlyNameAndNumber(customers);
            return getcustomers;
        }else{
            throw new Exception("Active customers not found");
        }
    }

    @Override
    public String updateCustomerQuary(CustomerUpdateQuaryRequestDTO customerUpdateQuaryRequestDTO, int id) {
        if(customerRepo.existsById(id)){
            customerRepo.updateCustomerByQuary(customerUpdateQuaryRequestDTO.getCustomerName(), customerUpdateQuaryRequestDTO.getNic(), id);
            return "updated customer id : " + id;
        }else{
            return "Customer not exists id : " + id;
        }
    }

    @Override
    public CustomerDTO getCustomerByNic(String nic){
        Optional<Customer> customer = customerRepo.findAllByNicEquals(nic);
        if(customer.isPresent()){
            CustomerDTO customerDTO = customerMapper.entityToDto(customer.get());
            return customerDTO;
        }else{
            throw new NotFoundException("not found");
        }
    }

    @Override
    public ResponseCustomerIdDTO searchCustomerByid(int id) throws Exception {
        Optional<Customer> customer = customerRepo.findById(id);
        if(customer.isPresent()){
            ResponseCustomerIdDTO responseCustomerNicDTO = customerMapper.entityToResponceDtoTwo(customer.get());
            return responseCustomerNicDTO;
        }else{
            throw new Exception("Customer not found");
        }
    }

    @Override
    public String updateCustomerSpecCols(CustomerUpdateTwoRequestDTO customerUpdateTwoRequestDTO, int id) throws Exception {
        if(customerRepo.existsById(id)){
            Customer customer = customerRepo.getReferenceById(id);

            customer.setCustomerName(customerUpdateTwoRequestDTO.getCustomerName());
            customer.setCustomerSalary(customerUpdateTwoRequestDTO.getCustomerSalary());

            customerRepo.save(customer);
            return "Customer id : " + id + " updated ";
        }else{
            throw new Exception("Customer not found");
        }
    }

    @Override
    public int countCustomerByActiveState(boolean status) {
        int numberOfCustomers = customerRepo.countAllByActiveStateEquals(status);
        return numberOfCustomers;
    }

    @Override
    public long countAllCustomers() {
        long numberOfCustomers = customerRepo.count();
        return numberOfCustomers;
    }


}
