package com.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.Coche;
import com.project.entities.Compra;
import com.project.entities.UserHector;

public interface CocheRepository extends JpaRepository <Coche, Integer>{
	
	List<Coche> findByMatricula(String matricula);
	
	List<Coche> findByPropietario(UserHector propietario);
	
	List<Coche> findByCompra(Compra compra);

	//Coche editar(Coche car);
	
}
