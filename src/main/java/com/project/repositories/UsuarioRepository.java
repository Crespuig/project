package com.project.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.UserHector;


public interface UsuarioRepository extends JpaRepository <UserHector, Integer>{

	Optional<UserHector> findByEmail(String email);
	
}