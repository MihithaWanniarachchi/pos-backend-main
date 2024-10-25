package com.mihitha.backend.service.impl;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mihitha.backend.service.PosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mihitha.backend.dto.PosDto;
import com.mihitha.backend.entity.Item;
import com.mihitha.backend.entity.Pos;
import com.mihitha.backend.repository.ItemRepository;
import com.mihitha.backend.repository.PosRepository;

@Service
public class PosServiceImpl implements PosService {

    @Autowired
    private PosRepository posRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Pos> getAllOrders() {
        return posRepository.findAll();
    }

    @Override
    public Pos createOrder(PosDto posDto) {
        Pos pos = new Pos();
        List<Long> items = posDto.getItems();
        Set<Item> itemSet = new HashSet<>();
        pos.setTotal(0.0);

        for (Long itemId : items) {
            Item item = itemRepository.findById(itemId).orElse(null);

            if(item != null && item.getQty() != 0){
                itemSet.add(item);
                pos.setTotal(pos.getTotal()+item.getPrice());
                 //Reduce the QTY of current stock
                 item.setQty(item.getQty() - 1);
                 itemRepository.save(item);
                }
        }
        Double tax = pos.getTotal()*10/100;

        pos.setTax(tax);
        pos.setPosTime(LocalDateTime.now());
        pos.setItems(itemSet);

        return posRepository.save(pos);
    }

    @Override
    public Pos getOrderById(Long id) {
        return posRepository.findById(id).orElse(null);
    }
 
}
