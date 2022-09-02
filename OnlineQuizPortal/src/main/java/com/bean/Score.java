package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Score {
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int sid;
private String email;
private String title;
private int score;
public String getEmail() {
	return email;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
public int getSid() {
	return sid;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "Score [sid=" + sid + ", email=" + email + ", title=" + title + ", score=" + score + "]";
}



}
