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

public class Dna extends Base implements Serializable {

    @Column(name = "dna")
    private String dna;

    @Column(name = "valorMutante")
    private boolean isMutant;
}
