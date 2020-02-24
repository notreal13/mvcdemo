package com.example.mvcdemo.web;

import com.example.mvcdemo.model.PersonForm;
import com.example.mvcdemo.service.PersonValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class FormController {

    @Resource
    private
    PersonValidator personValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(personValidator);
    }

    @GetMapping(path = "/form")
    public String showForm(PersonForm personForm) {
        return "form";
    }

    @PostMapping(path = "/form")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results";
    }
}
