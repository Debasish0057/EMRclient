package com.emr.client.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emr.client.entity.PatientFormRequest;

@RequestMapping("/emr")
public interface EMRClientControllerInterface {

	@PostMapping(path = "/patientform", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPatientDetails(@RequestBody PatientFormRequest patientForm);

}
