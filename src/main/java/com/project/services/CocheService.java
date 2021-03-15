package com.project.services;

import java.util.ArrayList;

import com.project.entities.Coche;

public interface CocheService {

	public void addCar(Coche c);
	public void updateCar(Coche c);
	public ArrayList<Coche> listCars();
	public Coche getCarById(int id);
	public void removeCar(int id);
	
}
