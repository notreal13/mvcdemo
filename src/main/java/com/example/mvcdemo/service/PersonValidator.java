package com.example.mvcdemo.service;

import com.example.mvcdemo.model.PersonForm;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;

@Service
public class PersonValidator implements Validator {

    @Resource
    private Validator entityValidator;

    @Override
    public boolean supports(Class<?> aClass) {
        return PersonForm.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        entityValidator.validate(obj, errors);
        PersonForm personForm = (PersonForm) obj;
        if (personForm.getAge() == null && StringUtils.isEmpty(personForm.getName())) {
            errors.reject("GlobalError", "Person form is empty!");
        }
    }
}
