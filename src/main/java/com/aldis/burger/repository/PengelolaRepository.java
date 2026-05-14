package com.aldis.burger.repository;

import com.aldis.burger.model.Pengelola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PengelolaRepository extends JpaRepository<Pengelola, Integer> {
    
}
