package com.pos.shopy.point_of_sale.dto.response;

import com.pos.shopy.point_of_sale.dto.request.OrderDetailsSaveRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseOrderDetailsDTO {
    //Customer
    private String customerName;
    private String customerAddress;
    private List<String> contactNumbers;

    //Order
    private Date date;
    private double total;
}
