package com.pos.shopy.point_of_sale.dto.paginated;

import com.pos.shopy.point_of_sale.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDTO {
    private List<ItemDTO> list;
    private long dataCount;
}
