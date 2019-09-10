package com.lubackiadam.springdemo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="patients")
public class Patient {

	@Column(name="first_name")
	private String firstName;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patient_id")
	private int id;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	
	public Patient() {
		
	}
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "patient_doctor", 
        joinColumns = { @JoinColumn(name = "patient_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "doctor_id") }
    )
    Set<Doctor> doctors = new HashSet<>();
	

	@Override
	public String toString() {
		return "Patient [firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + ", email=" + email + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
