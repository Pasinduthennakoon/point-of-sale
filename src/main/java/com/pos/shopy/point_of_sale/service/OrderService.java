package com.pos.shopy.point_of_sale.service;

import com.pos.shopy.point_of_sale.dto.request.OrderSaveRequestDTO;

public interface OrderService {
    String addOrder(OrderSaveRequestDTO orderSaveRequestDTO);

}
