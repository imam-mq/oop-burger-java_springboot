package com.aldis.burger.model;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "menu")
public class Menu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_pengelola;
    private Integer id_menu;
    private String nama_menu;
    private Double harga;
    private Boolean tersedia;
    private Integer stok_menu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pengelola", insertable = false, updatable = false)
    private Pengelola pengelola;
}
