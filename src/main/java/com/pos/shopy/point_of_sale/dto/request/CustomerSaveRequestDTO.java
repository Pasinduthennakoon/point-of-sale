package com.pos.shopy.point_of_sale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
// id and active state is not pass in frontend it is genarates by backend
public class CustomerSaveRequestDTO {

    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private List<String> contactNumbers;
    private String nic;
}
