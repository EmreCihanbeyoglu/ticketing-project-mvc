package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.IRoleService;
import com.cydeo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IRoleService roleService;

    @Autowired
    IUserService userService;

    @GetMapping("/create")
    public String getCreateUserFormPage(Model model) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "/user/create";
    }

}
