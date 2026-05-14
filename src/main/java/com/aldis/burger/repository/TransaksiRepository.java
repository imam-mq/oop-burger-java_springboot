package com.aldis.burger.repository;
import com.aldis.burger.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, Integer> {

    
}
