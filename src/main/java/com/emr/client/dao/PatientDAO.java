package com.emr.client.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emr.client.entity.PatientFormRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDAO extends JpaRepository<PatientFormRequest, Long> {
}
