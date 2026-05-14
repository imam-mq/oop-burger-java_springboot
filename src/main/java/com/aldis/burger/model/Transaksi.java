package com.aldis.burger.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "transaksi")
public class Transaksi {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_transaksi;

    private Integer id_menu;
    private Integer id_pembeli;
    private Integer id_pengelola;

    private Integer jumlah_item;
    private Double total_harga;
    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "id_pembeli", insertable = false, updatable = false)
    private Pembeli pembeli;

    @ManyToOne
    @JoinColumn(name = "id_menu", insertable = false, updatable = false)
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "id_pengelola", insertable = false, updatable = false)
    private Pengelola pengelola;
}
