package com.pos.shopy.point_of_sale.util.mappers;

import com.pos.shopy.point_of_sale.dto.ItemDTO;
import com.pos.shopy.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.pos.shopy.point_of_sale.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item RequestDtoToEntity(ItemSaveRequestDTO itemSaveRequestDTO);
    List<ItemDTO> PageToList(Page<Item> item);
}
