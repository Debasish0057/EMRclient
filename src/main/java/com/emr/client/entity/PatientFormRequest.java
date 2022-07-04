package com.emr.client.entity;

import java.io.Serializable;

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
@Table(name = "patient_form")
public class PatientFormRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_form_id", unique = true, nullable = false)
	private Long _id;

	private String title;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	@Column(unique = true)
	private String mobileNumber;
	private String age;
	private String city;
	private String state;

	@Override
	public String toString() {
		return "PatientFormRequest [title=" + title + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", age=" + age
				+ ", city=" + city + ", state=" + state + "]";
	}

}
