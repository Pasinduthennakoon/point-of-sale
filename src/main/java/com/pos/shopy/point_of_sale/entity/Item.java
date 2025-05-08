package com.pos.shopy.point_of_sale.entity;

import com.pos.shopy.point_of_sale.entity.enums.MeasuringUnitTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {

    @Id
    @Column(name = "item_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO) //genarate id on auto
    private int itemId;

    @Column(name = "item_name",length = 100,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measuring_units",length = 100,nullable = false)
    private MeasuringUnitTypes measuringUnit;

    @Column(name = "balance_qty",length = 100,nullable = false)
    private double balanceQty;

    @Column(name = "supplier_price",length = 100,nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price",length = 100,nullable = false)
    private double sellingPrice;
}
