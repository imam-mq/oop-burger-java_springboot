package com.aldis.burger.repository;
import com.aldis.burger.model.Bahan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BahanRepository extends JpaRepository<Bahan, Integer>{

    
}
