package com.purpleFireApi.service;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@Repository
public class UserInformationService {

	public String retriveUserInformation(String username) {
		JSONObject userObj = new JSONObject();

		try {
			if (username.equals("Mohamed")) {
				userObj.put("id", "tbnKddlq80");
				userObj.put("name", "Mohamed");

			} else if (username.equals("John")) {
				userObj.put("id", "E1RYSQOjRt");
				userObj.put("name", "John");

			} else if (username.equals("Kumar")) {
				userObj.put("id", "0PuRdHrJTh");
				userObj.put("name", "Kurma");

			}else {
				//forbidenResponse();
				return "No Such user";
				//throw new Exception("Forbidden");
				//throw ForbiddenException();

			}
		} catch (Exception e) {
			System.out.println("Exception in retriveUserInformation is  " + e.getMessage());
		} finally {
			// clear objects in memory
		}

		return userObj.toString();

	}
	
	@ResponseBody
	 @ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "Not Allowed")
	    public static String forbidenResponse() {
	        return "Class Level HTTP Status Overriden. The HTTP Status will be OK (CODE 200)\n";
	    } 

}


