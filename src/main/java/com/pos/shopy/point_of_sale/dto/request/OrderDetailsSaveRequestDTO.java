package com.pos.shopy.point_of_sale.dto.request;

import com.pos.shopy.point_of_sale.entity.Item;
import com.pos.shopy.point_of_sale.entity.Order;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsSaveRequestDTO {
    private String itemName;
    private double qty;
    private double amount;
    private int items;
}
