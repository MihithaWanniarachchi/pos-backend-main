package com.mihitha.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mihitha.backend.dto.StockDto;
import com.mihitha.backend.entity.Stock;

@Service
public interface StockService {

    Stock createStock(StockDto stockDto);
    Stock updateStock(Long stockId, StockDto stockDto);
    List<Stock> getStockByItemId(Long itemId);
    
}
