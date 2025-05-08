package com.pos.shopy.point_of_sale.util.mappers;

import com.pos.shopy.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.pos.shopy.point_of_sale.entity.Item;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-09T01:42:01+0530",
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
}
