package com.aldis.burger.service;
import com.aldis.burger.model.Transaksi;
import com.aldis.burger.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TransaksiService {
    
    @Autowired
    private TransaksiRepository transaksiRepository;

    // list transaksi
    public List<Transaksi> getAll() {
        return transaksiRepository.findAll();
    }

    // transaksi berdasarkan id
    public Optional<Transaksi> getById(Integer id) {
        return transaksiRepository.findById(id);
    }

    // simpan transaksi
    public Transaksi save(Transaksi transaksi) {
        return transaksiRepository.save(transaksi);
    }

    // delet transaksi
    public void delete(Integer id) {
        transaksiRepository.deleteById(id);
    }
}
