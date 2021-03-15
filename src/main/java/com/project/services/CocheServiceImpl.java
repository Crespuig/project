package com.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.project.dao.CocheDAO;
import com.project.entities.Coche;

public class CocheServiceImpl implements CocheService {

	private CocheDAO cocheDAO;

	public void setPersonDAO(CocheDAO cocheDAO) {
		this.cocheDAO = cocheDAO;
	}

	@Override
	@Transactional
	public void addCar(Coche c) {
		this.cocheDAO.addCar(c);
	}

	@Override
	@Transactional
	public void updateCar(Coche c) {
		this.cocheDAO.updateCar(c);
	}

	@Override
	@Transactional
	public ArrayList<Coche> listCars() {
		return this.cocheDAO.listCars();
	}

	@Override
	@Transactional
	public Coche getCarById(int id) {
		return this.cocheDAO.getCarById(id);
	}

	@Override
	@Transactional
	public void removeCar(int id) {
		this.cocheDAO.removeCar(id);
	}

}