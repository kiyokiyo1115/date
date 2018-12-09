package com.example.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.business.repository.DateRepository;
import com.example.business.domain.Date;
import com.example.business.domain.ResultDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;



@Service
public class DateService {
    @Autowired
    private DateRepository dateRepository;

    public List<Date> search() {
        return dateRepository.findAll();
    }

    public Optional<Date> findById(String id) {
        return dateRepository.findById(id);
    }

    public Date save(Date date) {
        return dateRepository.save(date);
    }

    public void deleteById(String id) {
        dateRepository.deleteById(id);
    }
    public List<ResultDate> createResultDate(List<Date> dates, LocalDate inputDate){
        List<ResultDate> resultDates = dates.stream().map(d -> new ResultDate(d, inputDate)).collect(Collectors.toList());

        return resultDates;
    }
    public List<ResultDate> calculateResultDate(String inputDate){
        List<Date> Dates = search();

        String[] dates = inputDate.split("/",0);

        LocalDate date = LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");


        List<ResultDate> resultDates = Dates.stream().map(d -> new ResultDate(d, date)).collect(Collectors.toList());

        return Dates.stream().map(d -> new ResultDate(d, date)).collect(Collectors.toList());}
    }  