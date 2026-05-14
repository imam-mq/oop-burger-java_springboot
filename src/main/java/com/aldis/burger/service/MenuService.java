package com.aldis.burger.service;
import com.aldis.burger.model.Menu;
import com.aldis.burger.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MenuService {
    
    @Autowired
    private MenuRepository menuRepository;

    // list menu
    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    // menu berdasarkan id
    public Optional<Menu> getById(Integer id) {
        return menuRepository.findById(id);
    }

    // simpan menu
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    // delet menu
    public void delete(Integer id) {
        menuRepository.deleteById(id);
    }
}
