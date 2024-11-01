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

public class Parcial1MutanteApplication implements CommandLineRunner { // La clase Parcial1MutanteApplication implementa la interfaz CommandLineRunner, que permite ejecutar código una vez que la aplicación ha iniciado. Esto es útil para realizar tareas de prueba o inicialización.

	@Autowired // Inyecta una instancia de DnaService en esta clase. DnaService es un servicio que contiene la lógica para analizar secuencias de ADN.
	private DnaService dnaService;

	public static void main(String[] args) {
		SpringApplication.run(Parcial1MutanteApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception { //crea un arreglo de cadenas llamado dna que representa una secuencia de ADN. Luego, llama al metodo isMutant del servicio dnaService para analizar si la secuencia pertenece a un mutante. Este ejemplo es solo para ver si funciona bien la aplicacion y que lo muestre en consola.
		try {
			String[] dna = {
					"AAAA",
					"AAGT",
					"AAAA",
					"AGGA"
			}; // Caso de array no cuadrado (NxM)
			boolean isMutant = dnaService.isMutant(dna);
			System.out.println("Is Mutant: " + isMutant); // Si la secuencia de ADN es válida y cumple con los patrones de mutante, imprimirá Is Mutant: true.
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage()); // Si la secuencia de ADN no es cuadrada o contiene filas nulas, se lanzará una excepción IllegalArgumentException, y se imprimirá el mensaje de error
		}
	}
}
