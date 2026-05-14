package com.aldis.burger.controller;
import com.aldis.burger.model.Pengelola;
import com.aldis.burger.service.PengelolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pengelola")
public class PengelolaController {
    
    @Autowired
    private PengelolaService pengelolaService;

    // get semua pengelola
    @GetMapping
    public List<Pengelola> getAll() {
        return pengelolaService.getAll();
    }

    // get pengelola berdasarkan id
    @GetMapping("/{id}")
    public ResponseEntity<Pengelola> getById(@PathVariable Integer id) {
        return pengelolaService.getById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // post pengelola
    @PostMapping
    public Pengelola create(@RequestBody Pengelola pengelola) {
        return pengelolaService.save(pengelola);
    }

    // put pengelola
    @PutMapping("/{id}")
    public ResponseEntity<Pengelola> update(@PathVariable Integer id, @RequestBody Pengelola pengelola) {
        return pengelolaService.getById(id)
            .map(existing -> {
                    existing.setNama_pengelola(pengelola.getNama_pengelola());
                    existing.setPeran(pengelola.getPeran());
                    existing.setJenis_kelamin(pengelola.getJenis_kelamin());
                    return ResponseEntity.ok(pengelolaService.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // delete pengelola
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return pengelolaService.getById(id)
            .map(existing -> {
                pengelolaService.delete(id);
                return ResponseEntity.ok().<Void>build();
            })
            .orElse(ResponseEntity.notFound().build());
    }
}
