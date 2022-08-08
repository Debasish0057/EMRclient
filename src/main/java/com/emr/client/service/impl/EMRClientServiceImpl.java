package com.emr.client.service.impl;

import com.emr.client.dao.PatientDAO;
import com.emr.client.dao.PatientReportDAO;
import com.emr.client.entity.PatientFormRequest;
import com.emr.client.entity.PatientReport;
import com.emr.client.response.commonResponse;
import com.emr.client.service.EMRClientService;
import com.emr.client.utils.EMRClientConstants;
import com.emr.client.utils.LogStack;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class EMRClientServiceImpl implements EMRClientService {

  private static final Logger logger = LoggerFactory.getLogger(PatientFormRequest.class);
  @Autowired
  PatientDAO patientDAO;
  @Autowired
  PatientReportDAO patientReportDAO;

  @Override
  public commonResponse savePatientDetailsService(PatientFormRequest patientForm) {

    logger.info(
        "002 - SERVICE - ENTRY - ID - " + patientForm.getMobileNumber() + " - " + String.valueOf(new LogStack(this.getClass().getSimpleName(),
            Thread.currentThread().getStackTrace()[1].getMethodName(), "",
            EMRClientConstants.SUCCESS,
            EMRClientConstants.SET_200)));

    commonResponse commonResponse = null;

    if (patientForm.getGender().equals("MALE")) {
      patientForm.setImgLocation("avatar");
    } else {
      patientForm.setImgLocation("avatar2");
    }

    patientForm.setCreatedDate(new Date(System.currentTimeMillis()));
    patientForm.setCreatedTime(new Time(System.currentTimeMillis()));
    patientForm.setUpdatedDate(new Date(System.currentTimeMillis()));
    patientForm.setUpdatedTime(new Time(System.currentTimeMillis()));
    try {
      PatientFormRequest patientFormRequest = patientDAO.save(patientForm);

      commonResponse = new commonResponse(EMRClientConstants.SUCCESS, "",
          String.valueOf(patientFormRequest.getPatient_form_id()), EMRClientConstants.SET_200);

      logger.info("002 - SERVICE - INBETWEEN - ID - " + patientForm.getMobileNumber() + " - " + String.valueOf(
          new LogStack(this.getClass().getSimpleName(),
              Thread.currentThread().getStackTrace()[1].getMethodName(), "",
              commonResponse.isSuccess(),
              commonResponse.getStatusCode())));

    } catch (DataIntegrityViolationException e) {
      commonResponse = new commonResponse(EMRClientConstants.FAILED, "Mobile Number Already Exist",
          "", EMRClientConstants.SET_500);
      logger.info("002 - SERVICE - EXCEPTION - ERROR DESC - ID - " + patientForm.getMobileNumber() + " - " + String.valueOf(
          e.toString() + " ==> " + e.getStackTrace()[0].getMethodName()
              + " ==> " + e.getStackTrace()[0].getLineNumber()));
    } catch (Exception e) {
      commonResponse = new commonResponse(EMRClientConstants.FAILED, e.toString(), "",
          EMRClientConstants.SET_500);
      logger.info("002 - SERVICE - EXCEPTION - ERROR DESC - ID - " + patientForm.getMobileNumber() + " - " + String.valueOf(
          e.toString() + " ==> " + e.getStackTrace()[0].getMethodName()
              + " ==> " + e.getStackTrace()[0].getLineNumber()));
    }
    logger.info("002 - SERVICE - EXIT - ID - " + patientForm.getMobileNumber() + " - " + String.valueOf(
        new LogStack(this.getClass().getSimpleName(),
            Thread.currentThread().getStackTrace()[1].getMethodName(), "",
            commonResponse.isSuccess(),
            commonResponse.getStatusCode())));

    return commonResponse;
  }

  @Override
  public List<PatientFormRequest> getAllPatientDetails() {
    return patientDAO.findAll();
  }

  @Override
  public PatientReport savePatientReport(PatientReport patientReport) {

    logger.info(
        "002 - SERVICE - ENTRY - ID - " + patientReport.getMobileNumber() + " - " + String.valueOf(new LogStack(this.getClass().getSimpleName(),
            Thread.currentThread().getStackTrace()[1].getMethodName(), "",
            EMRClientConstants.SUCCESS,
            EMRClientConstants.SET_200)));

    patientReport.setCreatedDate(new Date(System.currentTimeMillis()));
    patientReport.setCreatedTime(new Time(System.currentTimeMillis()));

    return patientReportDAO.save(patientReport);
  }

  @Override
  public List<PatientReport> getPatientCommunicationDetails(String mobileNumber) {
    List<PatientReport> getPatientReport;

    logger.info(
        "002 - SERVICE - ENTRY - ID - " + mobileNumber + " - " + String.valueOf(new LogStack(this.getClass().getSimpleName(),
            Thread.currentThread().getStackTrace()[1].getMethodName(), "",
            EMRClientConstants.SUCCESS,
            EMRClientConstants.SET_200)));

    getPatientReport = patientReportDAO.findBymobileNumber(mobileNumber);
    if(!getPatientReport.isEmpty()){

      logger.info("002 - SERVICE - EXIT - ID - " + mobileNumber + " - " + String.valueOf(
          new LogStack(this.getClass().getSimpleName(),
              Thread.currentThread().getStackTrace()[1].getMethodName(), EMRClientConstants.MOB_NO_NOT_FOUND,
              EMRClientConstants.SUCCESS,
              EMRClientConstants.SET_200)));

      return getPatientReport;
    }

    logger.info("002 - SERVICE - EXIT - ID - " + mobileNumber + " - " + String.valueOf(
        new LogStack(this.getClass().getSimpleName(),
            Thread.currentThread().getStackTrace()[1].getMethodName(), "",
            EMRClientConstants.FAILED,
            EMRClientConstants.SET_500)));

    return null;
  }

}
