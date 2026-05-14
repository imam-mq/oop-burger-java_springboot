package com.aldis.burger.model;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "pembeli")
public class Pembeli {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_pembeli;
    private String nama_pembeli;
}
