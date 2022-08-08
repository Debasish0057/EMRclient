package com.emr.client.entity;

import java.io.Serializable;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "patient_form")
public class PatientFormRequest implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "patient_form_id", unique = true, nullable = false)
  private Long patient_form_id;
  private String title;
  private String firstName;
  private String middleName;
  private String lastName;
  private String gender;
  private String age;
  @Column(unique = true)
  private String mobileNumber;
  private String city;
  private String state;
  private String imgLocation;
  private Date createdDate;
  private Time createdTime;
  private Date updatedDate;
  private Time updatedTime;
}
