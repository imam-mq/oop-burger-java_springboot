package com.aldis.burger.service;
import com.aldis.burger.model.Pembeli;
import com.aldis.burger.repository.PembeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PembeliService {

    @Autowired
    private PembeliRepository pembeliRepository;

    // list pembeli
    public List<Pembeli> getAll() {
        return pembeliRepository.findAll();
    }

    // pembeli berdasarkan id
    public Optional<Pembeli> getById(Integer id) {
        return pembeliRepository.findById(id);
    }

    // simpan pembeli
    public Pembeli save(Pembeli pembeli) {
        return pembeliRepository.save(pembeli);
    }

    // delet pembeli
    public void delete(Integer id) {
        pembeliRepository.deleteById(id);
    }
    
}
