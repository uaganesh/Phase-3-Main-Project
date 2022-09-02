package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Login;
import com.bean.Score;
import com.dao.AdminDao;
import com.dao.ScoreDao;

@Service
public class AdminService {
	
	@Autowired
	AdminDao onlineQuizDao;
	
	@Autowired
	ScoreDao scoreDao;
	
	
	public String checkAdminUser(String email,String password)
	{
		Login u=onlineQuizDao.checkAdmin(email);
		if(u==null)
		{
		  return null;
		}
		else
		{
			if((u.getEmail().equals(email))&&(u.getPassword().equals(password))&&(u.getUsertype().equals("admin")))
			{
				System.out.println("Success");
			  return "Admin Login Success";
			  
			}
			else
			{
				System.out.println("Failure");
				return "Invalid Credentials";
				
			}
		}
	}
	
	
	//Change password
	public String changePassword(Login l)
	{
		int result=onlineQuizDao.updatePassword(l);
		if(result==0)
		{
		  return "No user found";
		}
		else
		{
			return "password Updated Successfully";
		}
		
		
	}
	
	

}
