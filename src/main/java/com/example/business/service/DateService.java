package com.example.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.business.repository.DateRepository;
import com.example.business.domain.Date;

@Service
public class DateService {
    @Autowired
    private DateRepository dateRepository;

    public List<Date> findAll() {
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

	
	}