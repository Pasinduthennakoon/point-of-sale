package com.pos.shopy.point_of_sale.service;

import com.pos.shopy.point_of_sale.dto.ItemDTO;
import com.pos.shopy.point_of_sale.dto.paginated.PaginatedResponseItemDTO;
import com.pos.shopy.point_of_sale.dto.request.ItemSaveRequestDTO;

import java.util.List;

public interface ItemService {
    String addItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemDTO> getAllItems();

    List<ItemDTO> getAllItemsByStateType(boolean status);

    String updateItemActiveState(int id, boolean status);

    boolean deleteItemById(int id);

    long countItemByActiveState(boolean status);

    long countAllItems();

    PaginatedResponseItemDTO getAllItemsPaginated(int page, int size);

}
