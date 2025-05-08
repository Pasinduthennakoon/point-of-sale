package com.pos.shopy.point_of_sale.util.mappers;

import com.pos.shopy.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.pos.shopy.point_of_sale.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item RequestDtoToEntity(ItemSaveRequestDTO itemSaveRequestDTO);
}
