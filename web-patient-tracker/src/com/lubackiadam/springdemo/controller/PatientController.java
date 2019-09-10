package com.lubackiadam.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lubackiadam.springdemo.dao.PatientDAO;
import com.lubackiadam.springdemo.entity.Patient;
import com.lubackiadam.springdemo.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@RequestMapping("/checkPatients")
	public String checkPatients(@RequestParam("doctorId")int theId, Model theModel) {
		
		List<Patient> thePatients=patientService.checkPatients(theId);
		theModel.addAttribute("patients", thePatients);
		return "list-patients";
	}
	
	//public String listPatients(Model theModel) {
		
		//get patient from Service
		//List<Patient> thePatients=patientService.getPatients();
		//add patients to model
		//theModel.addAttribute("patients", thePatients);
		//return "list-patients";
	//}
	@GetMapping("/showFormAdd")
	public String showFormAdd(Model theModel) {
		//create patient to bind data form
		Patient thePatient= new Patient();
		theModel.addAttribute("patient",thePatient);
		
		return "patient-form";
	}
	@PostMapping("/savePatient")
	public String savePatient(@ModelAttribute("patient") Patient thePatient) {
		
		//save patient using service
		patientService.savePatient(thePatient);
		
		return "redirect:/patient/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("patientId")int theId, Model theModel) {
		
		Patient thePatient = patientService.getPatient(theId);
		theModel.addAttribute("patient", thePatient);
		return "patient-form";
	}
	@GetMapping("/deletePatient")
	public String deletePatient(@RequestParam("patientId")int theId) {
		patientService.deletePatient(theId);
		
		
		return "redirect:/patient/list";
	}
}
