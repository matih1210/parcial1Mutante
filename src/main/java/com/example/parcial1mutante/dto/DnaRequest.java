package com.example.parcial1mutante.dto;

import com.example.parcial1mutante.validators.ValidDna;

public class DnaRequest {

    @ValidDna
    private String[] dna;

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }
}
