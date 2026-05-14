package com.aldis.burger.repository;
import com.aldis.burger.model.Pembeli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PembeliRepository extends JpaRepository<Pembeli, Integer> {

    
}
