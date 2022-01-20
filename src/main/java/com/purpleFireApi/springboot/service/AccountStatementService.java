package com.purpleFireApi.springboot.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class AccountStatementService {
	public String retrieveAccountStatements(String accountId) {

		JSONArray userObjArray = new JSONArray();
		String accountStatement = null;

		try {
			switch (accountId) {
			case "CbIJb0i3vQ": //
				JSONObject accountStatementObj = new JSONObject();
				accountStatementObj.put("accountNumber", "128376876123");
				accountStatementObj.put("description", "purchase of item abc");
				accountStatementObj.put("amount", "1233.23");
				accountStatementObj.put("date", "2020-19-12");
				userObjArray.put(accountStatementObj);

				JSONObject accountStatementObj1 = new JSONObject();
				accountStatementObj1.put("accountNumber", "128376876123");
				accountStatementObj1.put("description", "purchase of item abc");
				accountStatementObj1.put("amount", "1233.23");
				accountStatementObj1.put("date", "2020-16-10");
				userObjArray.put(accountStatementObj1);

				accountStatement = userObjArray.toString();

				break;

			case "zHBrXmNYKb":

				JSONObject accountStatementObj3 = new JSONObject();
				accountStatementObj3.put("accountNumber", "6376278362677");
				accountStatementObj3.put("description", "purchase of item abc");
				accountStatementObj3.put("amount", "1237.23");
				accountStatementObj3.put("date", "2020-09-11");
				userObjArray.put(accountStatementObj3);

				JSONObject accountStatementObj4 = new JSONObject();
				accountStatementObj4.put("accountNumber", "6376278362677");
				accountStatementObj4.put("description", "purchase of item abc");
				accountStatementObj4.put("amount", "253.23");
				accountStatementObj4.put("date", "2020-19-02");
				userObjArray.put(accountStatementObj4);

				accountStatement = userObjArray.toString();

				break;

			case "KzUgTywi02":

				JSONObject accountStatementObj5 = new JSONObject();
				accountStatementObj5.put("accountNumber", "6376278362678");
				accountStatementObj5.put("description", "purchase of item abc");
				accountStatementObj5.put("amount", "1437.93");
				accountStatementObj5.put("date", "2020-09-11");
				userObjArray.put(accountStatementObj5);

				JSONObject accountStatementObj6 = new JSONObject();
				accountStatementObj6.put("accountNumber", "6376278362678");
				accountStatementObj6.put("description", "purchase of item abc");
				accountStatementObj6.put("amount", "253.87");
				accountStatementObj6.put("date", "2020-19-08");
				userObjArray.put(accountStatementObj6);

				accountStatement = userObjArray.toString();

				break;

			default:
				accountStatement = "No Statement for the specified Account";
				break;
			}

		} catch (Exception e) {
			System.out.println("Exception in retrieveAccountStatements is  " + e.getMessage());
		}

		return accountStatement;
	}

}
