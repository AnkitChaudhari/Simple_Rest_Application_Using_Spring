package com.restapp.util;

import com.restapp.common.ResponseHeaderCode;
import com.restapp.common.ResponseHeaderMessage;
import com.restapp.model.ContactResponse;
import com.restapp.model.ResponseHeader;

public class ResponseGenerator {

	public static ContactResponse generateResponse(ResponseHeaderCode code,
			ResponseHeaderMessage message, Object body) {
		ContactResponse response = new ContactResponse();
		ResponseHeader header = new ResponseHeader();
		header.setCode(code.getCode());
		header.setMessage(message.getMessage());
		response.setResponseHeader(header);
		response.setBody(body);
		return response;
	}

}
