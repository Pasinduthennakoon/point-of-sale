package com.pos.shopy.point_of_sale.service.impl;

import com.pos.shopy.point_of_sale.dto.ItemDTO;
import com.pos.shopy.point_of_sale.dto.paginated.PaginatedResponseItemDTO;
import com.pos.shopy.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.pos.shopy.point_of_sale.entity.Item;
import com.pos.shopy.point_of_sale.exception.EntryDuplicationException;
import com.pos.shopy.point_of_sale.exception.NotFoundException;
import com.pos.shopy.point_of_sale.repo.ItemRepo;
import com.pos.shopy.point_of_sale.service.ItemService;
import com.pos.shopy.point_of_sale.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String addItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item = itemMapper.RequestDtoToEntity(itemSaveRequestDTO);
        item.setActiveState(true);
        if (!itemRepo.existsById(item.getItemId())) {
            return itemRepo.save(item).getItemName();
        } else {
            throw new EntryDuplicationException("Allready in database");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepo.findAll();

        List<ItemDTO> itemDTOS = modelMapper.map(items, new TypeToken<List<ItemDTO>>() {
        }.getType());
        return itemDTOS;
    }

    @Override
    public List<ItemDTO> getAllItemsByStateType(boolean status) {
        List<Item> items = itemRepo.findAllByActiveStateEquals(status);

        List<ItemDTO> itemDTOS = modelMapper.map(items, new TypeToken<List<ItemDTO>>() {
        }.getType());
        return itemDTOS;
    }

    @Override
    public String updateItemActiveState(int id, boolean status) {
        if (itemRepo.existsById(id)) {
            Item item = itemRepo.getReferenceById(id);
            item.setActiveState(status);
            itemRepo.save(item);
            return "successfully updated";
        } else {
            throw new NotFoundException("this item not found");
        }
    }

    @Override
    public boolean deleteItemById(int id) {
        if (itemRepo.existsById(id)) {
            itemRepo.deleteById(id);
            return true;
        } else {
            throw new NotFoundException("not found");
        }
    }

    @Override
    public long countItemByActiveState(boolean status) {
        long countItems = itemRepo.countAllByActiveStateEquals(status);
        return countItems;
    }

    @Override
    public long countAllItems() {
        long countItems = itemRepo.count();
        return countItems;
    }

    @Override
    public PaginatedResponseItemDTO getAllItemsPaginated(int page, int size) {
        Page<Item> getAllItemsByPaginated = itemRepo.findAll(PageRequest.of(page, size));
        return new PaginatedResponseItemDTO(
                itemMapper.PageToList(getAllItemsByPaginated),
                itemRepo.count()
        );
    }

    @Override
    public PaginatedResponseItemDTO getAllActiveItemsPaginated(int page, int size, boolean state) {
        Page<Item> getAllItemsByPaginated = itemRepo.findAllByActiveStateEquals(state, PageRequest.of(page, size));
        return new PaginatedResponseItemDTO(
                itemMapper.PageToList(getAllItemsByPaginated),
                itemRepo.countAllByActiveStateEquals(state)
        );
    }
}
