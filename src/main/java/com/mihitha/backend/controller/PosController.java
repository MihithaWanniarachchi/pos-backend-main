package com.mihitha.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mihitha.backend.dto.PosDto;
import com.mihitha.backend.entity.Pos;
import com.mihitha.backend.service.PosService;

@RestController
@CrossOrigin(origins = "*")
public class PosController {

    @Autowired
    private PosService posService;

    @GetMapping("/orders")
    public ResponseEntity<List<Pos>> getAllOrders() {
        return ResponseEntity.status(200).body(posService.getAllOrders());
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Pos> getOrderById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(posService.getOrderById(id));
    }

    @PostMapping("/orders")
    public ResponseEntity<Pos> createOrder(@RequestBody PosDto posDto) {
        Pos newOrder = posService.createOrder(posDto);

        return ResponseEntity.status(201).body(newOrder);
    }
    
}
