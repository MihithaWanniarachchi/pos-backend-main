package com.mihitha.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mihitha.backend.entity.Pos;

@Repository
public interface PosRepository extends JpaRepository<Pos, Long> {
    
}
