package com.pos.shopy.point_of_sale.dto;

import com.pos.shopy.point_of_sale.entity.enums.MeasuringUnitTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CostomerDTO {
    private int itemId;
    private String itemName;
    private MeasuringUnitTypes measuringUnit;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean activeState;
}
