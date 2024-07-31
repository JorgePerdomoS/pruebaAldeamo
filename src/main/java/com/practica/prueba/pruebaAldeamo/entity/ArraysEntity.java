package com.practica.prueba.pruebaAldeamo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "arrays")
public class ArraysEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "input_array")
    private String inputArray;
}
