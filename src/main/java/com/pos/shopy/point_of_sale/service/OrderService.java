package com.pos.shopy.point_of_sale.service;

import com.pos.shopy.point_of_sale.dto.paginated.PaginatedResponseOrderDetailsDTO;
import com.pos.shopy.point_of_sale.dto.request.OrderSaveRequestDTO;

public interface OrderService {
    String addOrder(OrderSaveRequestDTO orderSaveRequestDTO);

    PaginatedResponseOrderDetailsDTO getAllOrderDetails(boolean status, int page, int size);

    PaginatedResponseOrderDetailsDTO getAllOrderDetailsWithoutStatus(int page, int size);

}
