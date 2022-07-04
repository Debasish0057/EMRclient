package com.emr.client.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.emr.client.controller.EMRClientControllerInterface;
import com.emr.client.dao.PatientDAO;
import com.emr.client.entity.PatientFormRequest;
import com.emr.client.response.commonResponse;

@RestController
public class EMRClientController implements EMRClientControllerInterface {

	@Autowired
	PatientDAO patientDAO;

	@Override
	public ResponseEntity<?> getPatientDetails(PatientFormRequest patientForm) {
		commonResponse commonResponse = null;

		try {
			PatientFormRequest patientFormRequest = patientDAO.save(patientForm);
			commonResponse = new commonResponse("SUCCESS", "", String.valueOf(patientFormRequest.get_id()), 200);
		} catch (DataIntegrityViolationException e) {
			commonResponse = new commonResponse("FAILED", "Mobile Number Already Exist", "", 500);
		}

		return ResponseEntity.ok(commonResponse);
	}
}
