package com.mihitha.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {

    private String name;

    private Integer qty;

    private Double price;

    private Long categoryId;
    
}
