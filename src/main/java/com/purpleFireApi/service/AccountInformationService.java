package com.purpleFireApi.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AccountInformationService {
	public String retrieveAccountInfo(String userId) {
		JSONArray userObjArray = new JSONArray();
		String accountDetails = null;

		try {
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			System.out.println("*** name "+ name +" userId "+ userId);

			switch (userId) {
			case "qbnKddlq70": //
				JSONObject userAccount1Obj = new JSONObject();
				userAccount1Obj.put("id", "CbIJb0i3vQ");
				userAccount1Obj.put("accountType", "SAVING");
				userAccount1Obj.put("accountNumber", "128376876123");
				userAccount1Obj.put("IBAN", "AE000128376876123003");
				userAccount1Obj.put("balance", "891723.23");
				userAccount1Obj.put("balance", "USD");
				userObjArray.put(userAccount1Obj);

				JSONObject userAccount2Obj = new JSONObject();
				userAccount2Obj.put("id", "Bx9MstWLab");
				userAccount2Obj.put("accountType", "CURRENT");
				userAccount2Obj.put("accountNumber", "6376278362677");
				userAccount2Obj.put("IBAN", "AE0006376278362677003");
				userAccount2Obj.put("balance", "123123423.12");
				userAccount2Obj.put("balance", "EGP");
				userObjArray.put(userAccount2Obj);

				accountDetails = userObjArray.toString();

				break;

			case "E1RYSQOjRt":
				JSONObject accountObj = new JSONObject();
				accountObj.put("id", "bBHak6v7kx");
				accountObj.put("accountType", "LOAN");
				accountObj.put("accountNumber", "128376876123");
				accountObj.put("IBAN", "AE000128376876123003");
				accountObj.put("balance", "891723.23");
				accountObj.put("balance", "USD");
				userObjArray.put(accountObj);

				JSONObject accountObj2 = new JSONObject();
				accountObj2.put("id", "zHBrXmNYKb");
				accountObj2.put("accountType", "CURRENT");
				accountObj2.put("accountNumber", "6376278362677");
				accountObj2.put("IBAN", "AE0006376278362677003");
				accountObj2.put("balance", "123123423.12");
				accountObj2.put("balance", "EGP");
				userObjArray.put(accountObj2);

				accountDetails = userObjArray.toString();

				break;

			case "0PuRdHrJTh":
				JSONObject accountUserObj = new JSONObject();
				accountUserObj.put("id", "KzUgTywi02");
				accountUserObj.put("accountType", "CURRENT");
				accountUserObj.put("accountNumber", "6376278362678");
				accountUserObj.put("IBAN", "AE000128376876123003");
				accountUserObj.put("balance", "891723.23");
				accountUserObj.put("balance", "USD");
				userObjArray.put(accountUserObj);
				accountDetails = userObjArray.toString();

				break;

			default:
				accountDetails = "No Accounts for provided user ID";
				break;
			}

		} catch (Exception e) {
			System.out.println("Exception in retriveUserInformation is  " + e.getMessage());
		}

		return accountDetails;
	}

}
