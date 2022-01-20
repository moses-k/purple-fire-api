package com.purpleFireApi.springboot.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class AdminService {
	static String className = AdminService.class.getSimpleName();

	public String retriveNormalUsers() {
		JSONArray userObjArray = new JSONArray();
		// AdminService adminService = new AdminService();

		try {

			// Fetch data from db and put into Json
			
			JSONObject userObj = new JSONObject();
			userObj.put("name", "Mohamed");
			userObj.put("id", "tbnKddlq80");
			userObjArray.put(userObj);
			
			JSONObject userObj2 = new JSONObject();
			userObj2.put("name", "John");
			userObj2.put("id", "E1RYSQOjRt");
			userObjArray.put(userObj2);
			
			JSONObject userObj3 = new JSONObject();
			userObj3.put("name", "Kurma");
			userObj3.put("id", "0PuRdHrJTh");
			userObjArray.put(userObj3);
		
		} catch (Exception e) {
			System.out.println("Exception in retriveNormalUsers is " + e.getMessage());
		} finally {
			//if (userObj != null)
			//	userObj = null;
		}

		return userObjArray.toString();
	}

}
