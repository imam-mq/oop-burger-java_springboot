package com.aldis.burger.service;
import com.aldis.burger.model.Pengelola;
import com.aldis.burger.repository.PengelolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PengelolaService {

    @Autowired
    private PengelolaRepository pengelolaRepository;

    // list pengelola
    public List<Pengelola> getAll() {
        return pengelolaRepository.findAll();
    }

    // pengelola berdasarkan id
    public Optional<Pengelola> getById(Integer id) {
        return pengelolaRepository.findById(id);
    }

    // simpan pengelola
    public Pengelola save(Pengelola pengelola) {
        return pengelolaRepository.save(pengelola);
    }

    // delet pengelola
    public void delete(Integer id) {
        pengelolaRepository.deleteById(id);
    }
    
}
