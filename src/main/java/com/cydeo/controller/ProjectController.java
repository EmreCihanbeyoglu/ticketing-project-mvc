package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.service.IProjectService;
import com.cydeo.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {


    IProjectService projectService;
    IUserService userService;

    public ProjectController(IProjectService projectService, IUserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String displayProjectCreateForm(Model model) {

        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projectList", projectService.findAll());
        model.addAttribute("managerList", userService.findAll());
        return "/project/create";
    }

}
