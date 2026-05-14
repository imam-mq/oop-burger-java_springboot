package com.aldis.burger.controller;


import com.aldis.burger.model.Menu;
import com.aldis.burger.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    // get menu
    @GetMapping
    public List<Menu> getAll() {
        return menuService.getAll();
    }

    // get menu berdasarkan id
    @GetMapping("/{id}")
    public ResponseEntity<Menu> getById(@PathVariable Integer id) {
        return menuService.getById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // post menu
    @PostMapping
    public Menu create(@RequestBody Menu menu) {
        return menuService.save(menu);
    }

    // put menu
    @PutMapping("/{id}")
    public ResponseEntity<Menu> update(@PathVariable Integer id, @RequestBody Menu menu) {
        return menuService.getById(id)
                .map(existing -> {
                    existing.setNama_menu(menu.getNama_menu());
                    existing.setHarga(menu.getHarga());
                    existing.setTersedia(menu.getTersedia());
                    existing.setStok_menu(menu.getStok_menu());
                    return ResponseEntity.ok(menuService.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // delete menu
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return menuService.getById(id)
            .map(existing -> {
                menuService.delete(id);
                return ResponseEntity.ok().<Void>build();
            })
            .orElse(ResponseEntity.notFound().build());
    }


    
}
