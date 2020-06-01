package com.evleeena.petclinic.controllers;

import com.evleeena.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @Resource
    private OwnerService ownerService;

    @RequestMapping({"", "/"})
    public String ownerList(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/list";
    }

    @RequestMapping("find")
    public String findOwner(Model model) {
        return "notimplemented";
    }
}
