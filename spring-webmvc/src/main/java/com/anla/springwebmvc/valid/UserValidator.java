package com.anla.springwebmvc.valid;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/5/24 10:06
 **/
@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (user.getUserName().length() < 8){
            errors.rejectValue("user", "valid.userNameLen", new Object[]{"minLength",8}, "用户名不能少于{1}位");
        }
    }

}
