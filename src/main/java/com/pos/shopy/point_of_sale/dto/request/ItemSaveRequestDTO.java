package com.pos.shopy.point_of_sale.dto.request;

import com.pos.shopy.point_of_sale.entity.enums.MeasuringUnitTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemSaveRequestDTO {
    private String itemName;
    private MeasuringUnitTypes measuringUnit;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
}
