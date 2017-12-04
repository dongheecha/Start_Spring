package com.javalec.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.javalec.model.Student;
import com.javalec.model.StudentValid;

public class handleValidator implements Validator {

    @Override
    public boolean supports(Class<?> arg0) {
        // TODO Auto-generated method stub

        return StudentValid.class.isAssignableFrom(arg0); // 검증할 객체의 클래스 타입 정보

    }

    @Override
    public void validate(Object obj, Errors erros) {
        // TODO Auto-generated method stub

        StudentValid student = (StudentValid) obj;
        /*
        String name = student.getName();

        if (name == null || name.trim().isEmpty()) {
            erros.rejectValue("name", "trouble");
        }*/
        
        ValidationUtils.rejectIfEmptyOrWhitespace(erros, "name", "trouble");

        int id = student.getId();
        if (id == 0) {
            erros.rejectValue("id", "trouble");
        }

        System.out.println("getMethod" + obj.getClass().getMethods());

    }

}
