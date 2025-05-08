package com.pos.shopy.point_of_sale.service.impl;

import com.pos.shopy.point_of_sale.repo.ItemRepo;
import com.pos.shopy.point_of_sale.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;
}
