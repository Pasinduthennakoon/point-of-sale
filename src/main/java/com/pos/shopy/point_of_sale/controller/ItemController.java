package com.pos.shopy.point_of_sale.controller;

import com.pos.shopy.point_of_sale.dto.ItemDTO;
import com.pos.shopy.point_of_sale.dto.paginated.PaginatedResponseItemDTO;
import com.pos.shopy.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.pos.shopy.point_of_sale.exception.InvalidInputException;
import com.pos.shopy.point_of_sale.service.ItemService;
import com.pos.shopy.point_of_sale.util.StandardResponse;
import jakarta.validation.constraints.Max;
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
            params = {"state"} //frontend can pass to state only "active","inactive" and "all"
    )
    public ResponseEntity<StandardResponse> getAllItemsByState(@RequestParam(value = "state") String state) {
        if (state.equalsIgnoreCase("active") | state.equalsIgnoreCase("inactive")) {

            //return active and inactive items
            boolean status = state.equalsIgnoreCase("active") ? true : false;
            List<ItemDTO> allItems = itemService.getAllItemsByStateType(status);

            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200, "Success", allItems),
                    HttpStatus.OK
            );
        } else {

            //return all items
            List<ItemDTO> allItems = itemService.getAllItems();

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
    public ResponseEntity<StandardResponse> getAllItemCountByState(@RequestParam(value = "state") String state) {
        long itemCount = 0;
        if (state.equalsIgnoreCase("active") | state.equalsIgnoreCase("inactive")) {

            boolean status = state.equalsIgnoreCase("active") ? true : false;
            itemCount = itemService.countItemByActiveState(status);

        } else {
            itemCount = itemService.countAllItems();
        }
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "customer count", itemCount),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = {"/get-all-item-paginated"},
            params = {"page", "size"}
    )
    public ResponseEntity<StandardResponse> getAllItemsPaginated(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size
    ){
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getAllItemsPaginated(page, size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", paginatedResponseItemDTO),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = {"/get-all-active-item-paginated"},
            params = {"page", "size","activeState"}
    )
    public ResponseEntity<StandardResponse> getAllActiveItemsPaginated(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size,
            @RequestParam(value = "activeState")boolean state
    ){
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getAllActiveItemsPaginated(page, size, state);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", paginatedResponseItemDTO),
                HttpStatus.OK
        );
    }
}
