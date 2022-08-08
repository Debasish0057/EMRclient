package com.emr.client.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LogStack {

  private String className;
  private String methodName;
  private String requestData;
  private boolean isSuccess;
  private int statusCode;

}
