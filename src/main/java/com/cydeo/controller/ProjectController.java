package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.IProjectService;
import com.cydeo.service.IRoleService;
import com.cydeo.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {


    IProjectService projectService;
    IUserService userService;
    IRoleService roleService;

    public ProjectController(IProjectService projectService, IUserService userService, IRoleService roleService) {
        this.projectService = projectService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @ModelAttribute("projectList")
    public List<ProjectDTO> getAllProjects() {
        return projectService.findAll();
    }

    @ModelAttribute("managerList")
    public List<UserDTO> getAllManagers() {
        return userService.filterManagers();
    }

    @GetMapping("/create")
    public String displayProjectCreateForm(Model model) {

        model.addAttribute("project", new ProjectDTO());
        return "/project/create";
    }

    @PostMapping("/create")
    public String saveProject(@ModelAttribute("project") ProjectDTO project, Model model) {

        projectService.save(project);

        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectCode}")
    public String displayUpdateProjectForm(@PathVariable String projectCode, Model model) {
        ProjectDTO projectToUpdate = projectService.findById(projectCode);
        model.addAttribute("projectToUpdate", projectToUpdate);
        return "/project/update";
    }

    @PostMapping("/update")
    public String updateProject(@ModelAttribute("projectToUpdate") ProjectDTO projectToUpdate) {
        System.out.println("project to update: " + projectToUpdate);
        projectService.update(projectToUpdate);
        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectCode}")
    public String deleteProject(@PathVariable("projectCode") String projectCode) {
        projectService.deleteById(projectCode);
        return "redirect:/project/create/";
    }


    @GetMapping("/complete/{projectCode}")
    public String completeProject(@PathVariable("projectCode") String projectCode) {
        projectService.completeProjectById(projectCode);
        return "redirect:/project/create";
    }




}
