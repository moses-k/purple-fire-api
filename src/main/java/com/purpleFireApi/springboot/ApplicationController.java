package com.purpleFireApi.springboot;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.purpleFireApi.service.AccountInformationService;
import com.purpleFireApi.service.AccountStatementService;
import com.purpleFireApi.service.AdminService;
import com.purpleFireApi.service.UserInformationService;

@RestController
@RequestMapping("/api")
public class ApplicationController {
	
	@Autowired
	private AdminService admin;
	@Autowired
	private UserInformationService userInfo;
	@Autowired
	private AccountInformationService accountInfo;
	@Autowired
	private AccountStatementService accountStatements;
	
	@RequestMapping("/users")
	public String user() {
		return admin.retriveNormalUsers();
	}
	
    @RequestMapping(path="user/{username}")
	public String userInformation(@PathVariable("username") String username) {
		return userInfo.retriveUserInformation( username);
	}
	
    @RequestMapping(path="accounts/{userid}")
	public String accountInformation(@PathVariable("userid") String userid) {
		return accountInfo.retrieveAccountInfo(userid);
	}

    @RequestMapping("accounts/statements")
	public String accountStatement(@RequestParam("accountId") String accountId ) {
    	//return accountId;
		return accountStatements.retrieveAccountStatements(accountId);
	}
   
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, Model m) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            System.out.println("========= invalidating session");
        }
//       / m.addAttribute("patient", newStuff());
        return "redirect:/login"; 
    }
}

