package com.aldis.burger.repository;
import com.aldis.burger.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    
}
