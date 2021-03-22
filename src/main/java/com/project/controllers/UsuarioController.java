package com.project.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.entities.UserHector;
import com.project.exceptions.UserNotFoundException;
import com.project.repositories.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioRepository repository;
		

	UsuarioController(UsuarioRepository repository) {
		this.repository = repository;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@CrossOrigin
	@GetMapping("/usuarios")
	@ResponseBody
	List<UserHector> all() {
		return repository.findAll();
	}
	// end::get-aggregate-root[]

	@PostMapping("/usuarios/new")
	@ResponseBody
	UserHector newUser(@RequestBody UserHector newUser) {
		return repository.save(newUser);
	}

	// Single item

	@GetMapping("/usuarios/{id}")
	@ResponseBody
	UserHector one(@PathVariable int id) {

		return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	@PutMapping("/usuarios/{id}")
	@ResponseBody
	UserHector replaceUser(@RequestBody UserHector newUser, @PathVariable int id) {

		return repository.findById(id).map(user -> {
			user.setEmail(newUser.getEmail());
			user.setPassword(newUser.getPassword());
			return repository.save(user);
		}).orElseGet(() -> {
			newUser.setId(id);
			return repository.save(newUser);
		});
	}

	@DeleteMapping("/usuarios/delete/{id}")
	@ResponseBody
	void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}

	@PostMapping("/usuarios/login")
	public ResponseEntity<UserHector> login(@RequestBody UserHector user) {

		UserHector userInDatabase = repository.findByEmail(user.getEmail())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Login incorrecto"));
		if (!userInDatabase.getPassword().equals(user.getPassword())) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Login incorrecto");
			
		}
		return new ResponseEntity<UserHector>(userInDatabase, HttpStatus.OK);
	}
	
	//@PostMapping("/usuarios/registro")
	

	@PostMapping("/usuarios/signup")
	public ResponseEntity<UserHector> signUp(@RequestBody UserHector user) {
		return new ResponseEntity<UserHector>(repository.save(user), HttpStatus.OK);
	}

	public Optional<UserHector> buscarPorEmal( String email) {
		return repository.findByEmail(email);
	}

}
