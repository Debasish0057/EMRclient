package com.emr.client.controller.impl;

import com.emr.client.controller.EMRClientController;
import com.emr.client.entity.PatientReport;
import com.emr.client.service.EMRClientService;

import com.emr.client.utils.EMRClientConstants;
import com.emr.client.utils.LogStack;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.emr.client.entity.PatientFormRequest;
import com.emr.client.response.commonResponse;

@RestController
public class EMRClientControllerImpl implements EMRClientController {

  private static final Logger logger = LoggerFactory.getLogger(EMRClientControllerImpl.class);
  @Autowired
  EMRClientService emrClientService;

  @Override
  public ResponseEntity<?> savePatientDetails(PatientFormRequest patientForm) {

    logger.info(
        "001 - CONTROLLER - ENTRY - ID - " + patientForm.getMobileNumber() + " - " + String.valueOf(new LogStack(this.getClass().getSimpleName(),
            Thread.currentThread().getStackTrace()[1].getMethodName(), patientForm.toString(),
            EMRClientConstants.SUCCESS,
            EMRClientConstants.SET_200)));

    commonResponse commonResponse = emrClientService.savePatientDetailsService(patientForm);

    logger.info(
        "001 - CONTROLLER - EXIT - ID - " + patientForm.getMobileNumber() + " - " + String.valueOf(new LogStack(this.getClass().getSimpleName(),
            Thread.currentThread().getStackTrace()[1].getMethodName(), "",
            commonResponse.isSuccess(),
            commonResponse.getStatusCode())));

    return ResponseEntity.ok(commonResponse);
  }

  @Override
  public ResponseEntity<?> getAllPatient() {
    logger.info(
        "001 - CONTROLLER - ENTRY - " + String.valueOf(new LogStack(this.getClass().getSimpleName(),
            Thread.currentThread().getStackTrace()[1].getMethodName(),
            EMRClientConstants.NO_REQ, EMRClientConstants.SUCCESS,
            EMRClientConstants.SET_200)));

    return ResponseEntity.ok(emrClientService.getAllPatientDetails());
  }

  @Override
  public ResponseEntity<?> savePatientCommunication(PatientReport patientReport) {
    logger.info(
        "001 - CONTROLLER - ENTRY - ID - " + patientReport.getMobileNumber() + " - " + String.valueOf(new LogStack(this.getClass().getSimpleName(),
            Thread.currentThread().getStackTrace()[1].getMethodName(),
            patientReport.toString(), EMRClientConstants.SUCCESS,
            EMRClientConstants.SET_200)));

    return ResponseEntity.ok(emrClientService.savePatientReport(patientReport));
  }

  @Override
  public ResponseEntity<?> getPatientCommunicationDetails(String mobileNumber) {
    logger.info(
        "001 - CONTROLLER - ENTRY - ID - " + mobileNumber + " - " + String.valueOf(new LogStack(this.getClass().getSimpleName(),
            Thread.currentThread().getStackTrace()[1].getMethodName(),
            mobileNumber, EMRClientConstants.SUCCESS,
            EMRClientConstants.SET_200)));

    List<PatientReport> patientReportList = emrClientService.getPatientCommunicationDetails(
        mobileNumber);

    if (patientReportList == null) {

      commonResponse commonResponse = new commonResponse();
      commonResponse.setSuccess(EMRClientConstants.FAILED);
      commonResponse.setErrorMsg(EMRClientConstants.MOB_NO_NOT_FOUND);
      commonResponse.setStatusCode(EMRClientConstants.SET_418);

      logger.info(
          "001 - CONTROLLER - INBETWEEN - ID - " + mobileNumber + " - " + String.valueOf(new LogStack(this.getClass().getSimpleName(),
              Thread.currentThread().getStackTrace()[1].getMethodName(),
              mobileNumber, EMRClientConstants.FAILED,
              EMRClientConstants.SET_418)));

      return ResponseEntity.status(commonResponse.getStatusCode()).body(commonResponse);
    }

    logger.info(
        "001 - CONTROLLER - EXIT - ID - " + mobileNumber + " - " + String.valueOf(new LogStack(this.getClass().getSimpleName(),
            Thread.currentThread().getStackTrace()[1].getMethodName(), "",
            EMRClientConstants.SUCCESS,
            EMRClientConstants.SET_200)));

    return ResponseEntity.ok(patientReportList);
  }

}
