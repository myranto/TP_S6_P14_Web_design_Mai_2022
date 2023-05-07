package com.spring.springmvc_v_finale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView mod = new ModelAndView();
        return mod;
    }
    @PostMapping("/save")
    public ModelAndView saveArticle(){
        ModelAndView mod = new ModelAndView();
        return mod;
    }
}
