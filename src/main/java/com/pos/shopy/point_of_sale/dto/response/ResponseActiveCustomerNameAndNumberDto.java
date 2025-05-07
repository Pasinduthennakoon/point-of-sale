package com.pos.shopy.point_of_sale.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseActiveCustomerNameAndNumberDto {
    private String customerName;
    private List<String> contactNumbers;
}
