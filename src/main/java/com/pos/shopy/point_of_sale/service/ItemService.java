package com.pos.shopy.point_of_sale.service;

import com.pos.shopy.point_of_sale.dto.request.ItemSaveRequestDTO;

public interface ItemService {
    String addItem(ItemSaveRequestDTO itemSaveRequestDTO);

}
