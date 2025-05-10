package com.pos.shopy.point_of_sale.service;

import com.pos.shopy.point_of_sale.dto.CostomerDTO;
import com.pos.shopy.point_of_sale.dto.request.ItemSaveRequestDTO;

import java.util.List;

public interface ItemService {
    String addItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<CostomerDTO> getAllItems();

    List<CostomerDTO> getAllItemsByStateType(boolean status);

    String updateItemActiveState(int id, boolean status);

    boolean deleteItemById(int id);

}
