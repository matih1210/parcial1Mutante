package com.example.parcial1mutante.services;

import com.example.parcial1mutante.Entities.Dna;
import com.example.parcial1mutante.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.Arrays;

@Service // marca a DnaServiceImpl como un servicio de Spring, permitiendo que sea inyectado y gestionado por Spring.
public class DnaServiceImpl extends BaseServiceImpl<Dna, Long> implements DnaService {

    @Autowired
    private DnaRepository dnaRepository; // dnaRepository es inyectado mediante Spring para poder interactuar con la base de datos y guardar las entidades Dna.

    public DnaServiceImpl(DnaRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public boolean isMutant(String[] dna) {
        // Convertimos el array de ADN a una matriz para su análisis
        char[][] dnaMatrix = convertToMatrix(dna);
        boolean isMutant = checkAllSequences(dnaMatrix, 0, 0, 0);

        // Creamos la entidad Dna para guardar el resultado en la base de datos
        Dna dnaEntity = new Dna();
        dnaEntity.setDna(Arrays.toString(dna)); // Guardamos el ADN en forma de cadena
        dnaEntity.setMutant(isMutant); // Guardamos si es mutante o no

        // Guardamos el resultado en la base de datos
        dnaRepository.save(dnaEntity);

        return isMutant;
    }

    private boolean checkAllSequences(char[][] dna, int row, int col, int sequencesFound) { // Este metodo recorre toda la matriz buscando secuencias de letras iguales de longitud 4 en cada dirección.
        if (sequencesFound > 1) return true; // Incrementa sequencesFound cuando encuentra una secuencia. Si sequencesFound es mayor a 1, retorna true indicando que el ADN es mutante. La recursión permite que el análisis se realice en todas las posiciones de la matriz.
        if (row >= dna.length) return false;

        if (hasHorizontalSequence(dna, row, col, 4) ||
                hasVerticalSequence(dna, row, col, 4) ||
                hasDiagonalSequence(dna, row, col, 4) ||
                hasReverseDiagonalSequence(dna, row, col, 4)) {
            sequencesFound++;
        } // Los métodos hasHorizontalSequence, hasVerticalSequence, hasDiagonalSequence, y hasReverseDiagonalSequence comprueban si en una posición específica hay cuatro letras consecutivas iguales en cada dirección.Si una de las secuencias se cumple en el rango especificado, retorna true.

        if (col + 1 >= dna[0].length) {
            return checkAllSequences(dna, row + 1, 0, sequencesFound);
        }

        return checkAllSequences(dna, row, col + 1, sequencesFound);
    }

    private char[][] convertToMatrix(String[] dna) {
        char[][] dnaMatrix = new char[dna.length][dna[0].length()];
        for (int i = 0; i < dna.length; i++) {
            dnaMatrix[i] = dna[i].toCharArray();
        }
        return dnaMatrix;
    }

    private boolean hasHorizontalSequence(char[][] dna, int row, int col, int length) {
        if (col + 3 >= dna[0].length) return false;
        return (dna[row][col] == dna[row][col + 1] &&
                dna[row][col + 1] == dna[row][col + 2] &&
                dna[row][col + 2] == dna[row][col + 3]);
    }

    private boolean hasVerticalSequence(char[][] dna, int row, int col, int length) {
        if (row + 3 >= dna.length) return false;
        return (dna[row][col] == dna[row + 1][col] &&
                dna[row + 1][col] == dna[row + 2][col] &&
                dna[row + 2][col] == dna[row + 3][col]);
    }

    private boolean hasDiagonalSequence(char[][] dna, int row, int col, int length) {
        if (row + 3 >= dna.length || col + 3 >= dna[0].length) return false;
        return (dna[row][col] == dna[row + 1][col + 1] &&
                dna[row + 1][col + 1] == dna[row + 2][col + 2] &&
                dna[row + 2][col + 2] == dna[row + 3][col + 3]);
    }

    private boolean hasReverseDiagonalSequence(char[][] dna, int row, int col, int length) {
        if (row + 3 >= dna.length || col - 3 < 0) return false;
        return (dna[row][col] == dna[row + 1][col - 1] &&
                dna[row + 1][col - 1] == dna[row + 2][col - 2] &&
                dna[row + 2][col - 2] == dna[row + 3][col - 3]);
    }

    // Metodo que guarda una secuencia de ADN y determina si es mutante.
    public boolean saveDna(String[] dna) {
        String dnaSequence = String.join(",", dna);

        Optional<Dna> existingDna = dnaRepository.findByDna(dnaSequence);

        if (existingDna.isPresent()) {
            return existingDna.get().isMutant();
        }

        boolean isMutant = isMutant(dna);
        Dna dnaEntity = Dna.builder()
                .dna(dnaSequence)
                .isMutant(isMutant)
                .build();
        dnaRepository.save(dnaEntity);

        return isMutant(dna);
    }
}
