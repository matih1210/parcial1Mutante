package com.example.parcial1mutante;

import com.example.parcial1mutante.services.DnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.parcial1mutante.repositories")
@EntityScan(basePackages = "com/example/parcial1mutante/Entities")
public class Parcial1MutanteApplication implements CommandLineRunner {

	@Autowired
	private DnaService dnaService;

	public static void main(String[] args) {
		SpringApplication.run(Parcial1MutanteApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception {
		try {
			String[] dna = {
					"AAAA",
					"AAGT",
					"AAAA",
					"AGGA"
			}; // Caso de array no cuadrado (NxM)
			boolean isMutant = dnaService.isMutant(dna);
			System.out.println("Is Mutant: " + isMutant);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage()); // Debería devolver: "El array de ADN debe ser cuadrado (NxN) y no contener filas nulas"
		}
	}
}
