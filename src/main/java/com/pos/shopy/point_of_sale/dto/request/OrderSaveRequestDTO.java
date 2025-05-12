package com.pos.shopy.point_of_sale.dto.request;

import com.pos.shopy.point_of_sale.entity.Customer;
import com.pos.shopy.point_of_sale.entity.OrderDetails;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderSaveRequestDTO {
    private int customer;
    private Date date;
    private double total;
    private List<OrderDetailsSaveRequestDTO> orderDetails;
}
