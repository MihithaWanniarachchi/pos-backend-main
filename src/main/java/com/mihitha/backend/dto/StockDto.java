package com.mihitha.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockDto {

    private Long id;

    private String name;

    private Long itemId;

    private Integer qty;
    
}
