package com.mihitha.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mihitha.backend.dto.PosDto;
import com.mihitha.backend.entity.Pos;

@Service
public interface PosService {

    List<Pos> getAllOrders();
    Pos getOrderById(Long id);
    Pos createOrder(PosDto posDto);
    
}
