package com.pos.shopy.point_of_sale.util.mappers;

import com.pos.shopy.point_of_sale.dto.ItemDTO;
import com.pos.shopy.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.pos.shopy.point_of_sale.entity.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-10T20:33:21+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public Item RequestDtoToEntity(ItemSaveRequestDTO itemSaveRequestDTO) {
        if ( itemSaveRequestDTO == null ) {
            return null;
        }

        Item item = new Item();

        item.setItemName( itemSaveRequestDTO.getItemName() );
        item.setMeasuringUnit( itemSaveRequestDTO.getMeasuringUnit() );
        item.setBalanceQty( itemSaveRequestDTO.getBalanceQty() );
        item.setSupplierPrice( itemSaveRequestDTO.getSupplierPrice() );
        item.setSellingPrice( itemSaveRequestDTO.getSellingPrice() );

        return item;
    }

    @Override
    public List<ItemDTO> PageToList(Page<Item> item) {
        if ( item == null ) {
            return null;
        }

        List<ItemDTO> list = new ArrayList<ItemDTO>();
        for ( Item item1 : item ) {
            list.add( itemToItemDTO( item1 ) );
        }

        return list;
    }

    protected ItemDTO itemToItemDTO(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setItemId( item.getItemId() );
        itemDTO.setItemName( item.getItemName() );
        itemDTO.setMeasuringUnit( item.getMeasuringUnit() );
        itemDTO.setBalanceQty( item.getBalanceQty() );
        itemDTO.setSupplierPrice( item.getSupplierPrice() );
        itemDTO.setSellingPrice( item.getSellingPrice() );
        itemDTO.setActiveState( item.isActiveState() );

        return itemDTO;
    }
}
