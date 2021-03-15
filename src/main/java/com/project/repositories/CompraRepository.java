package com.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.Compra;
import com.project.entities.UserHector;

public interface CompraRepository extends JpaRepository <Compra, Integer>{
	
	List<Compra> findByPropietario(UserHector propietario);
	
}
