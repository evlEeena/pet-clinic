package com.evleeena.petclinic.controllers;

import com.evleeena.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/vets")
public class VetController {

    @Resource
    private VetService vetService;

    @RequestMapping({"", "/"})
    public String vetList(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/list";
    }
}
