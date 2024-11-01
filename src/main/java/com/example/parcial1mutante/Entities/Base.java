package com.example.parcial1mutante.Entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@MappedSuperclass // Con esta anotacion la clase se convierte en MappedSuperCLass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public  abstract class Base implements Serializable { // Generno una clase base de la cual todas la clases hijas van a heredar el id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // El id es autogenerado
    private Long id;
}
