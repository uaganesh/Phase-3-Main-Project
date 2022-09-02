package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Score;
import com.dao.ScoreDao;

@Service
public class ScoreService {
	
	@Autowired
	ScoreDao scoreDao;
	
	
	public String scoreCheck(Score score)
	{
		return scoreDao.checkScore(score.getEmail(),score.getTitle());
		
	}
	
	public List<Score> getRank()
	{
		return scoreDao.getStandingPosition(); 
	}
	
	
	
	

}
