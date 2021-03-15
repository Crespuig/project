package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.entities.Coche;


public class CocheDAOImpl implements CocheDAO{

	private static final Logger logger = LoggerFactory.getLogger(CocheDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addCar(Coche c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		logger.info("Person saved successfully, Person Details="+c);
	}

	@Override
	public void updateCar(Coche c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		logger.info("Car updated successfully, Person Details="+c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Coche> listCars() {
		Session session = this.sessionFactory.getCurrentSession();
		ArrayList<Coche> carsList = (ArrayList<Coche>) session.createQuery("from Car").list();
		for(Coche p : carsList){
			logger.info("Person List::"+p);
		}
		return carsList;
	}

	@Override
	public Coche getCarById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Coche p = (Coche) session.load(Coche.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removeCar(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Coche p = (Coche) session.load(Coche.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}

	

	
	
}
