package com.emr.client.service;

import com.emr.client.entity.PatientFormRequest;
import com.emr.client.entity.PatientReport;
import com.emr.client.response.commonResponse;
import java.util.List;


public interface EMRClientService {

  public commonResponse savePatientDetailsService(PatientFormRequest patientForm);

  public List<PatientFormRequest> getAllPatientDetails();

  public PatientReport savePatientReport(PatientReport patientReport);

  public List<PatientReport> getPatientCommunicationDetails(String mobileNumber);

}
