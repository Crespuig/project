package com.project.dao;

import java.util.ArrayList;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


import com.project.entities.Coche;

@Component
public interface CocheDAO {

	public void addCar(Coche c);
	public void updateCar(Coche c);
	public ArrayList<Coche> listCars();
	public Coche getCarById(int id);
	public void removeCar(int id);
	
}
