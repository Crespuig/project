package com.project.dao;

import java.util.ArrayList;

import com.project.entities.UserHector;


public interface UserDAO {

	public void addCar(UserHector u);
	public void updateCar(UserHector u);
	public ArrayList<UserHector> listUsers();
	public UserHector getUserById(int id);
	public void removeCar(String email);
	
}
