package com.project.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.entities.Coche;
import com.project.entities.Compra;
import com.project.entities.UserHector;
import com.project.exceptions.CarNotFoundException;
import com.project.repositories.CocheRepository;
import com.project.repositories.CompraRepository;

@RestController
public class CocheController {

	@Autowired
	CocheRepository cocheRepository;

	CocheController(CocheRepository repository) {
		this.cocheRepository = repository;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@CrossOrigin
	@GetMapping("/coches/listCoches")
	List<Coche> all() {
		return cocheRepository.findAll();
	}
	// end::get-aggregate-root[]

	@CrossOrigin
	@PostMapping("/coches/new")
	Coche newCar(@RequestBody Coche newCar) {
//		Coche cocheDatabase = (Coche) cocheRepository.findByMatricula(matricula);
//		
//		if(cocheDatabase.getMatricula().equals(newCar.getMatricula())) {
//			return;
//		}
		return cocheRepository.save(newCar);

	}

	// Single item

	@CrossOrigin
	@GetMapping("/coches/{id}")
	Coche one(@PathVariable int id) {
		return cocheRepository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
	}

	@CrossOrigin
	@PutMapping("/coches/{id}")
	Coche replaceCar(@RequestBody Coche newCar, @PathVariable int id) {

		return cocheRepository.findById(id).map(car -> {
			car.setMarca(newCar.getMarca());
			car.setModelo(newCar.getModelo());
			car.setMatricula(newCar.getMatricula());
			return cocheRepository.save(car);
		}).orElseGet(() -> {
			newCar.setId(id);
			return cocheRepository.save(newCar);
		});
	}

	@CrossOrigin
	@DeleteMapping("/coches/delete/{id}")
	void deleteCar(@PathVariable int id) {
		cocheRepository.deleteById(id);
	}

	public List<Coche> cocheDeUnPropietario(UserHector u) {
		return cocheRepository.findByPropietario(u);
	}

	public List<Coche> cochesDeUnaCompra(Compra c) {
		return cocheRepository.findByCompra(c);
	}

	public List<Coche> buscar(String matricula) {
		return cocheRepository.findByMatricula(matricula);
	}

}
