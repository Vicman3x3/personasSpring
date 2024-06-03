package com.vicman.primerweb;

import com.vicman.primerweb.entities.Persona;
import com.vicman.primerweb.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.List;

@SpringBootApplication
public class PrimerWebApplication implements CommandLineRunner {

	@Autowired
	public PersonaRepository personaRepository;

	public static void main(String[] args) {
		SpringApplication.run(PrimerWebApplication.class, args);

		//Persona persona = new Persona();
		//persona.setId(1L);
		//persona.setNombre("Juan");
		//persona.setEdad(20);
		//personaRepository.save(persona);

	}

	@Override
	public void run(String... args) throws Exception {
		personaRepository.save(new Persona(1L, "Manutoh", 20));
		personaRepository.save(new Persona(2L, "Carla", 22));
		personaRepository.save(new Persona(3L, "Fernanda", 21));
		personaRepository.save(new Persona(4L, "Gonzalo", 20));

		System.out.println("Numero de personas guardadas: " + personaRepository.count());

		List<Persona> personas = personaRepository.findAll();
		personas.forEach( p -> System.out.println("Nombre de la persona es" + p.getNombre() ));

	}
}
