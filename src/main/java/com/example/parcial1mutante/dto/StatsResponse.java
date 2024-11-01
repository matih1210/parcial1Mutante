package com.example.parcial1mutante.dto;

public class StatsResponse { // Creo un DTO StatsResponse para calcular las Stats y devolverlo a en forma de ese DTO
    private int countMutantDna;
    private int countHumanDna;
    private double ratio;

    public StatsResponse(int countMutantDna, int countHumanDna, double ratio) {
        this.countMutantDna = countMutantDna;
        this.countHumanDna = countHumanDna;
        this.ratio = countMutantDna > 0 ? (double) countMutantDna/countHumanDna: 0.0;
    }
    public int getCountMutantDna() {
        return countMutantDna;
    }

    public void setCountMutantDna(int countMutantDna) {
        this.countMutantDna = countMutantDna;
    }

    public int getCountHumanDna() {
        return countHumanDna;
    }

    public void setCountHumanDna(int countHumanDna) {
        this.countHumanDna = countHumanDna;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

}

