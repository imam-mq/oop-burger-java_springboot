package com.aldis.burger.controller;

import com.aldis.burger.model.Pembeli;
import com.aldis.burger.service.PembeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pembeli")
public class PembeliController {
    
    @Autowired
    private PembeliService pembeliService;

    // get data pembeli
    @GetMapping
    public List<Pembeli> getAll() {
        return pembeliService.getAll();
    }

    // get pembeli berdasarkan id
    @GetMapping("/{id}")
    public ResponseEntity<Pembeli> getById(@PathVariable Integer id) {
        return pembeliService.getById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // post pembeli
    @PostMapping
    public Pembeli create(@RequestBody Pembeli pembeli) {
        return pembeliService.save(pembeli);
    }

    // put data pembeli
    @PutMapping("/{id}")
    public ResponseEntity<Pembeli> update(@PathVariable Integer id, @RequestBody Pembeli pembeli) {
        return pembeliService.getById(id)
            .map(existing -> {
                existing.setNama_pembeli(pembeli.getNama_pembeli());
                return ResponseEntity.ok(pembeliService.save(existing));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    // delet pembeli
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
            return pembeliService.getById(id)
                .map(existing -> {
                    pembeliService.delete(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
