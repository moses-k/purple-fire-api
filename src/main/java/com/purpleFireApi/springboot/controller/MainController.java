package com.purpleFireApi.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.purpleFireApi.springboot.modal.User;
import com.purpleFireApi.springboot.service.AccountInformationService;
import com.purpleFireApi.springboot.service.AccountStatementService;
import com.purpleFireApi.springboot.service.AdminService;
import com.purpleFireApi.springboot.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class MainController {
	
	@Autowired
	private AdminService admin;
	@Autowired
	private UserServiceImpl userDetails;
	@Autowired
	private AccountInformationService accountInfo;
	@Autowired
	private AccountStatementService accountStatements;
	
	@GetMapping(path = "/users") // Compliant
	public List<User> user() {
		return userDetails.get();
	}
	
    @PostMapping(path="user/{username}")
	public User userInformation(@PathVariable("username") String username) {
		return userDetails.get(0);
	}
	
    @PostMapping(path="accounts/{userid}")
	public String accountInformation(@PathVariable("userid") String userid) {
		return accountInfo.retrieveAccountInfo(userid);
	}

    @GetMapping(path="accounts/statements")
	public String accountStatement(@RequestParam("accountId") String accountId ) {
    	//return accountId;
		return accountStatements.retrieveAccountStatements(accountId);
	}
   
    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request, Model m) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            System.out.println("========= invalidating session");
        }
        return "redirect:/login"; 
    }
}

