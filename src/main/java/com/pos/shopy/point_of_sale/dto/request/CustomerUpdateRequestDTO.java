package com.pos.shopy.point_of_sale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerUpdateRequestDTO {

    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private List<String> contactNumbers;
    private String nic;
    private boolean activeState;
}
