package com.example.business.domain;

import java.time.LocalDate;

public class ResultDate {
	public String id;
	public String name;
	public LocalDate resultDate;
	public String calculateFormula;

    public ResultDate(Date date, LocalDate date2) {
        this.id = date.getid();     
        this.name = date.getname();
        this.resultDate = date2;
        resultDate = resultDate.plusDays(date.getday());
        resultDate = resultDate.plusMonths(date.getmonth());
        resultDate = resultDate.plusYears(date.getyear());
        this.calculateFormula = date.getyear() + "/" + date.getmonth() + "/" + date.getday();
    }

    public String getid() {
        return id;
    }
    
    public void setid(String id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public LocalDate getResultDate() {
        return resultDate;
    }

    public void setResultDate(LocalDate resultDate) {
        this.resultDate = resultDate;
    }

    public String getCalculateFormula() {
        return calculateFormula;
    }

    public void setCalculateFormula(String calculateFormula) {
        this.calculateFormula = calculateFormula;
    }

    @Override
    public String toString() {
        return "ResultDate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resultDate=" + resultDate +
                ", calculateFormula='" + calculateFormula + '\'' +
                '}';
    }
}
