package com.example.business.controller;


import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.business.domain.Date;
import com.example.business.domain.ResultDate;
import com.example.business.service.DateService;

@Controller
@RequestMapping("/dates") 
public class DateController {
    @Autowired
    private DateService dateService;

    @GetMapping
    public String index(Model model) { 
        List<Date> dates = dateService.findAll();
        
        LocalDate initialDate = LocalDate.now();
        List<ResultDate> resultDates = dateService.createResultDate(dates, initialDate);
        
        model.addAttribute("dates", resultDates);
        return "dates/index"; 
    }

    @GetMapping("new")
    public String newdate(Model model) {
        return "dates/new";
    }

  

    @PostMapping
    public String create(@ModelAttribute Date date) { // ⑥
        dateService.save(date);	
        return "redirect:/dates"; // ⑦
    }

    @PostMapping("calculate")
    public String calculate(@ModelAttribute("baseDate") String baseDate, Model model){
        List<ResultDate> resultDates = dateService.calculateResultDate(baseDate);
        model.addAttribute("resultDates", resultDates);
        return "dates/index";
    }
    
    
    @PutMapping("{id}")
    public String update(@PathVariable String id, @ModelAttribute Date date) {
        date.setid(id);
        dateService.save(date);
        return "redirect:/dates";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable String id) {
        dateService.deleteById(id);
        return "redirect:/dates";
    }
    
    
}
