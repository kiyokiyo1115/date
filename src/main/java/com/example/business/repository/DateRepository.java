package com.example.business.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.business.domain.Date;

@Repository
public interface DateRepository extends JpaRepository<Date, String >  {


}