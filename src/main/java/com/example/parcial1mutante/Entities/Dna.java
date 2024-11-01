package com.example.parcial1mutante.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Audited

public class Dna extends Base implements Serializable { // Creo la clase dna y que implemente serializable para convertirlo en una secuencia de bytes

    @Column(name = "dna") // El atributo donde se guarda un DNA
    private String dna;

    @Column(name = "valorMutante") // El atributo donte guarda El valor de mutante
    private boolean isMutant;
}
