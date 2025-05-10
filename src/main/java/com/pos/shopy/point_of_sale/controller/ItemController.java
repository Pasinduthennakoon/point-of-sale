package com.pos.shopy.point_of_sale.controller;

import com.pos.shopy.point_of_sale.dto.CostomerDTO;
import com.pos.shopy.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.pos.shopy.point_of_sale.exception.InvalidInputException;
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
        List<CostomerDTO> allItems = itemService.getAllItems();

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", allItems),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = {"/get-all-item-by-state"},
            params = {"state"} //frontend can pass to state only "active","inactive" and "all"
    )
    public ResponseEntity<StandardResponse> getAllItemsByState(@RequestParam(value = "state") String state) {
        if (state.equalsIgnoreCase("active") | state.equalsIgnoreCase("inactive")) {

            //return active and inactive items
            boolean status = state.equalsIgnoreCase("active") ? true : false;
            List<CostomerDTO> allItems = itemService.getAllItemsByStateType(status);

            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200, "Success", allItems),
                    HttpStatus.OK
            );
        } else {

            //return all items
            List<CostomerDTO> allItems = itemService.getAllItems();

            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200, "Success", allItems),
                    HttpStatus.OK
            );
        }
    }

    @PutMapping(
            path = {"/update-item-active-state"},
            params = {"id", "state"}
    )
    public ResponseEntity<StandardResponse> updateItemActiveState(@RequestParam(value = "id") int id, @RequestParam(value = "state") String state) {
        if(state.equalsIgnoreCase("active") | state.equalsIgnoreCase("inactive")){

            boolean status = state.equalsIgnoreCase("active") ? true : false;
            String resualt = itemService.updateItemActiveState(id, status);

            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200, "success", resualt),
                    HttpStatus.OK
            );
        }else {
            throw new InvalidInputException("please enter valid input");
        }
    }

    @DeleteMapping(
            path = {"/delete-item-by-id/{id}"}
    )
    public ResponseEntity<StandardResponse> deleteItemById(@PathVariable(value = "id")int id){
        boolean result = itemService.deleteItemById(id);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"successfully deleted",result),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = {"/get-item-count-by-state"},
            params = {"state"} //frontend can pass to state only "active","inactive" and "all"
    )
    public ResponseEntity<StandardResponse> getAllItemsCountByState(@RequestParam(value = "state") String state) {
        int itemcout = 0;
        String message = "";
        if (state.equalsIgnoreCase("active") | state.equalsIgnoreCase("inactive")) {

            //return active and inactive items
            boolean status = false;
            if(state.equalsIgnoreCase("active")){
                status = true;
                List<CostomerDTO> allItems = itemService.getAllItemsByStateType(status);
                itemcout = allItems.size();
                message = "active items";

            }else{
                List<CostomerDTO> allItems = itemService.getAllItemsByStateType(status);
                itemcout = allItems.size();
                message = "inactive items";
            }
        } else {

            //return all items
            List<CostomerDTO> allItems = itemService.getAllItems();
            itemcout = allItems.size();
            message = "all items";
        }
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, message, itemcout),
                HttpStatus.OK
        );
    }
}
