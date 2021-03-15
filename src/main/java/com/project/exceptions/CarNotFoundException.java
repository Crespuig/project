package com.project.exceptions;

public class CarNotFoundException extends RuntimeException {

	public CarNotFoundException(int id) {
	    super("Could not find car " + id);
	  }
	}