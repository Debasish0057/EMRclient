package com.emr.client.controller;

import com.emr.client.entity.PatientReport;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emr.client.entity.PatientFormRequest;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/emr")
public interface EMRClientController {

  @PostMapping(path = "/patientform", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> savePatientDetails(@RequestBody PatientFormRequest patientForm);

  @PostMapping(path = "/getallpatient")
  public ResponseEntity<?> getAllPatient();

  @PostMapping(path = "/patientchart", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> savePatientCommunication(
      @RequestBody PatientReport patientReport);

  @PostMapping(path = "/getpatientchart/{mobilenumber}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> getPatientCommunicationDetails(
      @PathVariable(name = "mobilenumber") String mobileNumber);
}
