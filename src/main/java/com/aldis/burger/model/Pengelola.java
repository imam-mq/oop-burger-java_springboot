package com.aldis.burger.model;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "pengelola")
public class Pengelola {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pengelola;

    private String nama_pengelola;
    private String peran;
    private String jenis_kelamin;
}
