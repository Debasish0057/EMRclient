package com.emr.client.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class commonResponse {
	private String status;
	private String errorMsg;
	private String id;
	private int statusCode;

	@Override
	public String toString() {
		return "ResponseEntity [status=" + status + ", statusCode=" + statusCode + "]";
	}

}