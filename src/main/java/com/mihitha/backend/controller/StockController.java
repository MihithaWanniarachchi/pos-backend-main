package com.mihitha.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mihitha.backend.dto.StockDto;
import com.mihitha.backend.entity.Stock;
import com.mihitha.backend.service.StockService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService){
        this.stockService =stockService;
    }

    @PostMapping("/add")
    public ResponseEntity<Stock> createStock(@RequestBody StockDto stockDto){
        Stock createdStock = stockService.createStock(stockDto);
        return new ResponseEntity<>(createdStock, HttpStatus.CREATED);
    }

    @PutMapping("/update/{stockId}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long stockId, @RequestBody StockDto stockDto){
        Stock updatedStock = stockService.updateStock(stockId, stockDto);
        return new ResponseEntity<>(updatedStock, HttpStatus.OK);
    }

    @GetMapping("/byItem/{itemId}")
    public ResponseEntity<List<Stock>> getStockByItemId(@PathVariable Long itemId){
        List<Stock> stockList = stockService.getStockByItemId(itemId);
        return new ResponseEntity<>(stockList, HttpStatus.OK);
    }
    
}
