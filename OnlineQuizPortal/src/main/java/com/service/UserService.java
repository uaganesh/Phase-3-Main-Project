package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Login;
import com.bean.User;
import com.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	UserDao userdao;
	
	public String StoreUserDetails(User u)
	{
		Login l=new Login();
		l.setEmail(u.getEmail());
		l.setPassword(u.getPassword());
		l.setUsertype("user");
		
		int result=userdao.signup(l);
		if(result==1)
		{
			int insertToUser=userdao.InsertToUSer(u);
			if(insertToUser==1)
			{
				return "User Signup Successfull";
			}
			else
			{
				return "Error Occured During Signup";
			}
		}
		else
		{
			return "Error occured! Try Again";
		}
	}
	
	
	public String checkUser(String email,String password)
	{
	Login l=userdao.checkUser(email);
	if(l==null)
	{
	  return null;
	}
	else
	{
		if((l.getEmail().equals(email))&&(l.getPassword().equals(password))&&(l.getUsertype().equals("user")))
		{
			System.out.println("Success");
		     return "User Login Success";
		  
		}
		else
		{
			System.out.println("Failure");
			return "Error";
			
		}
	}
}
	
		
				
	}
	


