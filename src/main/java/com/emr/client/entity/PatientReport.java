package com.emr.client.entity;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "patient_health_comm")
public class PatientReport {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "patient_health_comm_id", unique = true, nullable = false)
  private Long patient_illness_det_id;
  private String mobileNumber;
  private String patient_illness_det;
  private String patient_Symptoms;
  private String patient_cure_pres;
  private int reportedTo;
  private int reportedBy;
  private Date createdDate;
  private Time createdTime;
}
