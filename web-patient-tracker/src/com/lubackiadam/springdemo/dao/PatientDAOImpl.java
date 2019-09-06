package com.lubackiadam.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lubackiadam.springdemo.entity.Patient;

@Repository
public class PatientDAOImpl implements PatientDAO{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	
	public List<Patient>getPatients() {

		//get the current hibernate session
		Session currentSession =sessionFactory.getCurrentSession();
		//create a query
		Query<Patient> theQuery = 
				currentSession.createQuery("from Patient",Patient.class);
		//execute query and result list 
		List<Patient>patients=theQuery.getResultList();		
		// return the results
		
		
		return patients;
	}
	@Override
	public void savePatient(Patient thePatient) {
		//get the current hibernate session
				Session currentSession =sessionFactory.getCurrentSession();
		currentSession.save(thePatient);
	}

}
