package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.IRoleService;
import com.cydeo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public String saveUser(@ModelAttribute("user") UserDTO user){
        userService.save(user);
        return "redirect:/user/create";
    }

    @GetMapping("/update/{username}")
    public String retrieveUserToBeUpdated(@PathVariable("username") String username, Model model) {
        UserDTO userToBeUpdated = userService.findById(username);
        model.addAttribute("userToBeUpdated", userToBeUpdated);
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "/user/update";
    }

    @PostMapping("/update")
    public String updateUser(UserDTO userToBeUpdated) {
        userService.update(userToBeUpdated);

        return "redirect:/user/create";
    }

}
