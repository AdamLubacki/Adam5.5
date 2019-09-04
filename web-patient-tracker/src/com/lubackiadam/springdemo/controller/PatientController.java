package com.lubackiadam.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lubackiadam.springdemo.dao.PatientDAO;
import com.lubackiadam.springdemo.entity.Patient;
import com.lubackiadam.springdemo.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@RequestMapping("/list")
	public String listPatients(Model theModel) {
		
		//get patient from Service
		List<Patient> thePatients=patientService.getPatients();
		//add patients to model
		theModel.addAttribute("patients", thePatients);
		return "list-patients";
	}
}
