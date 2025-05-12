package com.pos.shopy.point_of_sale.service.impl;

import com.pos.shopy.point_of_sale.dto.CustomerDTO;
import com.pos.shopy.point_of_sale.dto.request.OrderSaveRequestDTO;
import com.pos.shopy.point_of_sale.entity.Order;
import com.pos.shopy.point_of_sale.entity.OrderDetails;
import com.pos.shopy.point_of_sale.repo.CustomerRepo;
import com.pos.shopy.point_of_sale.repo.ItemRepo;
import com.pos.shopy.point_of_sale.repo.OrderDetailsRepo;
import com.pos.shopy.point_of_sale.repo.OrderRepo;
import com.pos.shopy.point_of_sale.service.OrderService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    @Transactional
    public String addOrder(OrderSaveRequestDTO orderSaveRequestDTO) {
        Order order = new Order(
                customerRepo.getReferenceById(orderSaveRequestDTO.getCustomer()),
                orderSaveRequestDTO.getDate(),
                orderSaveRequestDTO.getTotal()

        );
        orderRepo.save(order);

        if (orderRepo.existsById(order.getOrderId())){
            List<OrderDetails> orderDetails = modelMapper.map(orderSaveRequestDTO.getOrderDetails(),new TypeToken<List<OrderDetails>>(){}.getType());

            //to set order id and item id of order details entity
            for(int i = 0; i < orderDetails.size(); i++){
                orderDetails.get(i).setOrders(order);
                orderDetails.get(i).setItems(itemRepo.getReferenceById(orderSaveRequestDTO.getOrderDetails().get(i).getItems()));
            }

            if (orderDetails.size() > 0){
                orderDetailsRepo.saveAll(orderDetails);
            }
            return "saved";
        }
        return null;
    }
}
