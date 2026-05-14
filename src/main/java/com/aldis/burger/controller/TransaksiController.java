package com.aldis.burger.controller;

import com.aldis.burger.model.Transaksi;
import com.aldis.burger.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/transaksi")
public class TransaksiController {
    
    @Autowired
    private TransaksiService transaksiService;

    // get data transaksi
    @GetMapping
    public List<Transaksi> getAll() {
        return transaksiService.getAll();
    }

    // get transaksi berdasarkan id
    @GetMapping("/{id}")
    public ResponseEntity<Transaksi> getById(@PathVariable Integer id) {
        return transaksiService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // post transaksi
    @PostMapping
    public Transaksi create(@RequestBody Transaksi transaksi) {
        transaksi.setCreated_at(LocalDateTime.now());
        return transaksiService.save(transaksi);
    }

    // put transaksi
    @PutMapping("/{id}")
    public ResponseEntity<Transaksi> update(@PathVariable Integer id, @RequestBody Transaksi transaksi) {
        return transaksiService.getById(id)
                .map(existing -> {
                    existing.setId_menu(transaksi.getId_menu());
                    existing.setId_pembeli(transaksi.getId_pembeli());
                    existing.setId_pengelola(transaksi.getId_pengelola());
                    existing.setJumlah_item(transaksi.getJumlah_item());
                    existing.setTotal_harga(transaksi.getTotal_harga());
                    return ResponseEntity.ok(transaksiService.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }


    // delete transaksi
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return transaksiService.getById(id)
                .map(existing -> {
                    transaksiService.delete(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
