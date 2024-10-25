package com.mihitha.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mihitha.backend.entity.Category;
import com.mihitha.backend.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i FROM Item i WHERE i.category = :category")
    List<Item> findItemsByCategory(@Param("category") Category category);
    
}
