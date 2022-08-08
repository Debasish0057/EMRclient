package com.emr.client;

import com.emr.client.dao.PatientDAO;
import com.emr.client.entity.PatientFormRequest;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EmRclientApplication {

  @Autowired
  PatientDAO patientDAO;

  public static void main(String[] args) {
    SpringApplication.run(EmRclientApplication.class, args);
  }


  @PostConstruct
  public void initUsers() {


    /*PatientFormRequest patientFormRequest1 = new PatientFormRequest();
    patientFormRequest1.setTitle("MR");
    patientFormRequest1.setFirstName("Amit");
    patientFormRequest1.setMiddleName("Kumar");
    patientFormRequest1.setLastName("Panda");
    patientFormRequest1.setGender("MALE");
    patientFormRequest1.setMobileNumber("7899699036");
    patientFormRequest1.setAge("26");
    patientFormRequest1.setCity("Khurdha");
    patientFormRequest1.setState("Odisha");
    patientFormRequest1.setImgLocation("");
    patientFormRequest1.setCreatedDate(new Date(System.currentTimeMillis()));
    patientFormRequest1.setCreatedTime(new Time(System.currentTimeMillis()));

    patientFormRequest1.setUpdatedDate(new Date(System.currentTimeMillis()));
    patientFormRequest1.setUpdatedTime(new Time(System.currentTimeMillis()));

    PatientFormRequest patientFormRequest2 = new PatientFormRequest();
    patientFormRequest2.setTitle("MR");
    patientFormRequest2.setFirstName("Debasish");
    patientFormRequest2.setMiddleName("");
    patientFormRequest2.setLastName("Pradhan");
    patientFormRequest2.setGender("MALE");
    patientFormRequest2.setMobileNumber("9777216305");
    patientFormRequest2.setAge("27");
    patientFormRequest2.setCity("Bhubaneswar");
    patientFormRequest2.setState("Odisha");
    patientFormRequest2.setImgLocation("");
    patientFormRequest2.setCreatedDate(new Date(System.currentTimeMillis()));
    patientFormRequest2.setCreatedTime(new Time(System.currentTimeMillis()));

    patientFormRequest1.setUpdatedDate(new Date(System.currentTimeMillis()));
    patientFormRequest1.setUpdatedTime(new Time(System.currentTimeMillis()));

    PatientFormRequest patientFormRequest3 = new PatientFormRequest();
    patientFormRequest3.setTitle("MS");
    patientFormRequest3.setFirstName("Poonam");
    patientFormRequest3.setMiddleName("");
    patientFormRequest3.setLastName("Behera");
    patientFormRequest3.setGender("FEMALE");
    patientFormRequest3.setMobileNumber("9776722685");
    patientFormRequest3.setAge("26");
    patientFormRequest3.setCity("Bhubaneswar");
    patientFormRequest3.setState("Odisha");
    patientFormRequest3.setImgLocation("");
    patientFormRequest3.setCreatedDate(new Date(System.currentTimeMillis()));
    patientFormRequest3.setCreatedTime(new Time(System.currentTimeMillis()));

    patientFormRequest3.setUpdatedDate(new Date(System.currentTimeMillis()));
    patientFormRequest3.setUpdatedTime(new Time(System.currentTimeMillis()));

    List<PatientFormRequest> patientForm = Stream.of(patientFormRequest1,patientFormRequest2,patientFormRequest3)
        .collect(Collectors.toList());
    System.out.println(patientForm);
    patientDAO.saveAll(patientForm);*/
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
      }
    };
  }
}
