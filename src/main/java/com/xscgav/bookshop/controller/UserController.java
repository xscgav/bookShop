package com.xscgav.bookshop.controller;

import com.xscgav.bookshop.entity.UserEntity;
import com.xscgav.bookshop.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new UserEntity());
        return "register_page";
    }

    @GetMapping("login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new UserEntity());
        return "login_page";
    }

    @PostMapping("/register")
        public UserEntity register(@ModelAttribute UserEntity userEntity){
        UserEntity registeredUser = userServiceImpl.findOrCreateUser(userEntity.getName(), userEntity.getSurname(), userEntity.getEmail(), userEntity.getPhone(), userEntity.getAddress());
        return registeredUser;
        }
}
