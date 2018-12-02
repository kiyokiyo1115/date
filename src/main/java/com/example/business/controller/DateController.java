package com.example.business.controller;


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
import com.example.business.service.DateService;

@Controller
@RequestMapping("/dates") 
public class DateController {
    @Autowired
    private DateService dateService;

    @GetMapping
    public String index(Model model) { 
        List<Date> dates = dateService.findAll();
        model.addAttribute("dates", dates);
        return "dates/index"; 
    }

    @GetMapping("new")
    public String newDate(Model model) {
        return "dates/new";
    }

  

    @PostMapping
    public String create(@ModelAttribute Date date) { // ⑥
        dateService.save(date);	
        return "redirect:/dates"; // ⑦
    }

    @PutMapping("{id}")
    public String update(@PathVariable String id, @ModelAttribute Date date) {
        date.setid(id);
        dateService.save(date);
        return "redirect:/dates";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable String id) {
        dateService.delete(id);
        return "redirect:/dates";
    }
    
    
}
