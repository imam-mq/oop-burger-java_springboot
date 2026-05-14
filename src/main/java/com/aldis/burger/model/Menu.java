package com.aldis.burger.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "menu")
public class Menu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private Integer id_menu;

    @Column(name = "id_pengelola")
    private Integer id_pengelola;

    @Column(name = "nama_menu")
    private String nama_menu;

    @Column(name = "harga")
    private Double harga;

    @Column(name = "tersedia")
    private Boolean tersedia;

    @Column(name = "stok_menu")
    private Integer stok_menu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pengelola", insertable = false, updatable = false)
    private Pengelola pengelola;
}