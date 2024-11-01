package com.example.parcial1mutante.dto;

public class DnaResponse { // Creo un DTO DnaResponse para mandar el resultado de la solicitud POST
    private boolean mutant;
    private String error;

    // Constructor para respuesta exitosa
    public DnaResponse(boolean mutant) {
        this.mutant = mutant;
    }

    // Constructor para respuesta con error
    public DnaResponse(String error) {
        this.error = error;
    }

    public boolean isMutant() {
        return mutant;
    }

    public String getError() {
        return error;
    }
}