package com.lubackiadam.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubackiadam.springdemo.dao.PatientDAO;
import com.lubackiadam.springdemo.entity.Patient;
@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDAO patientDao;
	@Override
	@Transactional
	public List<Patient> getPatients() {
		// TODO Auto-generated method stub
		return patientDao.getPatients();
	}
	@Override
	@Transactional
	public void savePatient(Patient thePatient) {

		patientDao.savePatient(thePatient);
	}

}
