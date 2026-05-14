package com.aldis.burger.repository;

import com.aldis.burger.model.Bahan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BahanRepository extends JpaRepository<Bahan, Integer> {
    
    @Query("SELECT b FROM Bahan b WHERE b.id_menu = :idMenu")
    List<Bahan> findByIdMenu(@Param("idMenu") Integer idMenu);
}