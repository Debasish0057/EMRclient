package com.emr.client.dao;

import com.emr.client.entity.PatientReport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientReportDAO extends JpaRepository<PatientReport, Long> {
  public List<PatientReport>  findBymobileNumber(String mobileNumber);
}
