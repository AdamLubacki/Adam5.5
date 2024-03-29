package com.lubackiadam.springdemo.dao;

import java.util.List;

import com.lubackiadam.springdemo.entity.Patient;

public interface PatientDAO {

	public List<Patient>getPatients();

	public void savePatient(Patient thePatient);

	public Patient getPatient(int theId);

	public void deletePatient(int theId);

	public List<Patient> checkPatients(int theId);
}
