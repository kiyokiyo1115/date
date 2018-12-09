	package com.example.business.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Date {
	
	@Id
	public String id;
	public String name;
	public Integer year;
	public Integer month;
	public Integer day;
	
   
    public String getid() {
        return id;
    }
    public void setid(String id) {
        this.id = id;
    }
    
    public String getname() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
    public Integer getyear() {
        return year;
    }
    public void setyear(Integer year) {
        this.year = year;
    }
    public Integer getmonth() {
        return month;
    }
    public void setmonth(Integer month) {
        this.month = month;
    }
    public Integer getday() {
        return day;
    }
    public void setday(Integer day) {
        this.day = day;
    }
    
    @Override
    public String toString() {
        return "Date [id=" + id + ",  name=" + name + ", year=" + year + ", month=" + month + ", day=" + day + "]";	
    }
}