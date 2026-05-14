package com.aldis.burger.controller;

import com.aldis.burger.model.Bahan;
import com.aldis.burger.service.BahanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/bahan")
public class BahanController {
    
    @Autowired
    private BahanService bahanService;

    // list data bahan
    @GetMapping
    public List<Bahan> getAll() {
        return bahanService.getAll();
    }

    // get bahan berdasarkan id
    @GetMapping("/{id}")
    public ResponseEntity<Bahan> getById(@PathVariable Integer id) {
        return bahanService.getById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    //post bahan
    @PostMapping
    public Bahan create(@RequestBody Bahan bahan) {
        return bahanService.save(bahan);
    }

    // put bahan berdasarkan id
    @PutMapping("/{id}")
    public ResponseEntity<Bahan> updaEntity(@PathVariable Integer id, @RequestBody Bahan bahan) {
        return bahanService.getById(id)
            .map(existing -> {
                existing.setNama_bahan(bahan.getNama_bahan());
                existing.setTersedia(bahan.getTersedia());
                existing.setStok_bahan(bahan.getStok_bahan());
                return ResponseEntity.ok(bahanService.save(existing));
            })
            .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return bahanService.getById(id)
            .map(existing -> {
                bahanService.delete(id);
                return ResponseEntity.ok().<Void>build();
            })
            .orElse(ResponseEntity.notFound().build());
    }
}
