package com.aldis.burger.service;
import com.aldis.burger.model.Bahan;
import com.aldis.burger.repository.BahanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class BahanService {
    
    @Autowired
    private BahanRepository bahanRepository;

    // list bahan
    public List<Bahan> getAll() {
        return bahanRepository.findAll();
    }

    // bahan berdasarkan id
    public Optional<Bahan> getById(Integer id) {
        return bahanRepository.findById(id);
    }

    // simpan bahan
    public Bahan save(Bahan bahan) {
        return bahanRepository.save(bahan);
    }

    // delet bahan
    public void delete(Integer id) {
        bahanRepository.deleteById(id);
    }
}
