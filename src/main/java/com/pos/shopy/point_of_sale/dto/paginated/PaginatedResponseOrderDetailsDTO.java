package com.pos.shopy.point_of_sale.dto.paginated;

import com.pos.shopy.point_of_sale.dto.response.ResponseOrderDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseOrderDetailsDTO {
    private  List<ResponseOrderDetailsDTO> list;
    private Long dataCount;
}
