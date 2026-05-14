package com.aldis.burger.model;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "bahan")
public class Bahan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_bahan;

    private Integer id_menu;
    private Integer id_pengelola;
    private String nama_bahan;
    private Boolean tersedia;
    private Integer stok_bahan;

    @ManyToOne
    @JoinColumn(name = "id_menu", insertable = false, updatable = false)
    private Menu menu;
    
}
