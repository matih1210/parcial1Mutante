package com.example.parcial1mutante.dto;

import com.example.parcial1mutante.validators.ValidDna;

public class DnaRequest { // Creo el un DTO DnaRequest para mandar la solicitud de POST de un forma mas facil

    @ValidDna
    private String[] dna;

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }
}
