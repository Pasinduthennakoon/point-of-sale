package com.pos.shopy.point_of_sale.dto.queryinterface;

import java.util.Date;
import java.util.List;

public interface OrderDetailsInterface {
    String getCustomerName();
    String getCustomerAddress();
    List<String> getContactNumbers();
    Date getDate();
    double getTotal();
}
