package com.pos.shopy.point_of_sale.controller;

import com.pos.shopy.point_of_sale.dto.CustomerDTO;
import com.pos.shopy.point_of_sale.dto.ItemDTO;
import com.pos.shopy.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.pos.shopy.point_of_sale.service.ItemService;
import com.pos.shopy.point_of_sale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(
            path = {"/save"}
    )
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String id = itemService.addItem(itemSaveRequestDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, id + " item successfully saved ", id),
                HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = {"/get-all-item"}
    )
    public ResponseEntity<StandardResponse> getAllItems() {
        List<ItemDTO> allItems = itemService.getAllItems();

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", allItems),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = {"/get-all-item-by-state"},
            params = {"state"}
    )
    public ResponseEntity<StandardResponse> getAllItemsByState(@RequestParam(value = "state") String state) {
        if (state.equalsIgnoreCase("active") | state.equalsIgnoreCase("inactive")) {
//            boolean status = false;
//            if(state.equalsIgnoreCase("active")){
//                status = true;
//            }
            boolean status = state.equalsIgnoreCase("active") ? true : false;
            List<ItemDTO> allItems = itemService.getAllItemsByStateType(status);

            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200, "Success", allItems),
                    HttpStatus.OK
            );
        } else {

            List<ItemDTO> allItems = itemService.getAllItems();

            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200, "Success", allItems),
                    HttpStatus.OK
            );
        }
    }
}
