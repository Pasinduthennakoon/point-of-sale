package com.pos.shopy.point_of_sale.controller;

import com.pos.shopy.point_of_sale.dto.paginated.PaginatedResponseOrderDetailsDTO;
import com.pos.shopy.point_of_sale.dto.request.OrderSaveRequestDTO;
import com.pos.shopy.point_of_sale.service.OrderService;
import com.pos.shopy.point_of_sale.util.StandardResponse;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(
            path = {"/save"}
    )
    public ResponseEntity<StandardResponse> saveOrders(@RequestBody OrderSaveRequestDTO orderSaveRequestDTO) {
        String id = orderService.addOrder(orderSaveRequestDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, id + " item successfully saved ", id),
                HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = {"/get-order-details"},
            params = {"stateType", "page", "size"}
    )
    public ResponseEntity<StandardResponse> getAllOrderDetails(
            @RequestParam(value = "stateType") String stateType,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size
    ){
        PaginatedResponseOrderDetailsDTO paginatedResponseOrderDetailsDTO = null;
        if(stateType.equalsIgnoreCase("active") | stateType.equalsIgnoreCase("inactive")){
            boolean status = stateType.equalsIgnoreCase("active") ? true : false;
            paginatedResponseOrderDetailsDTO = orderService.getAllOrderDetails(status, page, size);
        }







        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",paginatedResponseOrderDetailsDTO),
                HttpStatus.OK
        );
    }
}
