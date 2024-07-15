package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.model.Task;
import com.cydeo.service.IProjectService;
import com.cydeo.service.ITaskService;
import com.cydeo.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    IProjectService projectService;
    IUserService userService;
    ITaskService taskService;

    public TaskController(IProjectService projectService, IUserService userService, ITaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @ModelAttribute("projectList")
    public List<ProjectDTO> getProjectList() {
        return projectService.findAll();
    }

    @ModelAttribute("employeeList")
    public List<UserDTO> getEmployeeList() {
        return userService.filterEmployees();
    }

    @ModelAttribute("taskList")
    public List<TaskDTO> getTaskList() {
        return taskService.findAll();
    }

    @GetMapping("/create")
    public String showTaskCreateForm(Model model) {
        model.addAttribute("task", new TaskDTO());
        return "/task/create";
    }

    @PostMapping("/create")
    public String createTask(@ModelAttribute("task") TaskDTO task) {
        taskService.save(task);
        return "redirect:/task/create";
    }

    @GetMapping("/update/{taskId}")
    public String showUpdateTaskForm(@PathVariable("taskId") Long taskId, Model model) {
        model.addAttribute("taskToUpdate", taskService.findById(taskId));
        return "/task/update";
    }

    @PostMapping("/update/{taskId}")
    public String updateTask(@PathVariable("taskId") Long taskId, @ModelAttribute("taskToUpdate") TaskDTO taskToUpdate) {
        taskToUpdate.setId(taskId);
        taskService.update(taskToUpdate);
        return "redirect:/task/create";
    }

//    // if there is a field with the same name in the object, spring will re-set the value automatically,
//    // you don't need to use ModelAttiibute and set the value explicitly
//    @PostMapping("/update/{id}")
//    public String updateTask(TaskDTO taskToUpdate) {
//        taskService.update(taskToUpdate);
//        return "redirect:/task/create";
//    }


    @GetMapping("/create/{taskId}")
    public String deleteTask(@PathVariable("taskId") Long taskId) {
        taskService.deleteById(taskId);
        return "redirect:/task/create";
    }


    @GetMapping("/manager/project-status")
    public String showProjectStatusPage(Model model) {
//        Map<ProjectDTO, List<TaskDTO>> finishedTasksGroupedByProject = taskService.getFinishedTaskList().stream().collect(Collectors.groupingBy(TaskDTO::getProject));
        model.addAttribute("finishedTasksGroupedByProject", taskService.getFinishedTasksGroupedByProject());

//        Map<ProjectDTO, List<TaskDTO>> unfinishedTasksGroupedByProject = taskService.getUnfinishedTaskList().stream().collect(Collectors.groupingBy(TaskDTO::getProject));
        model.addAttribute("unfinishedTasksGroupedByProject", taskService.getUnfinishedTasksGroupedByProject());

        return "/manager/project-status";
    }

}
