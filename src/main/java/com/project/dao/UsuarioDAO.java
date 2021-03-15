package com.project.dao;

import java.util.ArrayList;

import com.project.entities.UserHector;

public interface UsuarioDAO {
	
	public void addUser(UserHector u);
	public void updateUser(UserHector u);
	public ArrayList<UserHector> listUsers();
	public UserHector getUserById(int id);
	public void removeUser(String email);

}
