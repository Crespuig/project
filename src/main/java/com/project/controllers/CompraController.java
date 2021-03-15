package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.Coche;
import com.project.entities.Compra;
import com.project.entities.UserHector;
import com.project.repositories.CocheRepository;
import com.project.repositories.CompraRepository;

@RestController
public class CompraController {

	@Autowired
	CompraRepository compraRepository;
	
	@Autowired 
	CocheRepository cocheRepository;
	
	@PostMapping("/compra/new")
	public Compra insertar(Compra c, UserHector u) {
		c.setPropietario(u);
		return compraRepository.save(c);
	}
	
	/*public Coche addCocheCompra(Coche car, Compra comp) {
		car.setCompra(comp);
		return cocheRepository.editar(car);
	}*/
	
	
	
	public Compra buscarPorId(int id) {
		return compraRepository.findById(id).orElse(null);
	}
	
	public List<Compra> todas(){
		return compraRepository.findAll();
	}
	
	public List<Compra> buscarPorPropietario(UserHector u){
		return compraRepository.findByPropietario(u);
	}
}
