package com.lubackiadam.springdemo.service;

import java.util.List;

import com.lubackiadam.springdemo.entity.Doctor;
import com.lubackiadam.springdemo.entity.Patient;

public interface PatientService {

	public List<Patient> getPatients();

	public void savePatient(Patient thePatient);

	public Patient getPatient(int theId);

	public void deletePatient(int theId);

	public List<Patient> checkPatients(int theId);

	
}
