package com.cydeo.bootstrap;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.enums.Status;
import com.cydeo.service.IProjectService;
import com.cydeo.service.IRoleService;
import com.cydeo.service.ITaskService;
import com.cydeo.service.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    IRoleService roleService;
    IUserService userService;
    IProjectService projectService;
    ITaskService taskService;


    public DataGenerator(IRoleService roleService, IUserService userService, IProjectService projectService, ITaskService taskService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) throws Exception {
        RoleDTO adminRole = new RoleDTO(1L, "Admin");
        RoleDTO managerRole = new RoleDTO(2L, "Manager");
        RoleDTO employeeRole = new RoleDTO(3L, "Employee");

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("Emre", "Cihan","emre.cihan@gmail.com", "a123", true, "48624650", managerRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Emre2", "Cihan","emre.cihan2@gmail.com", "a123", true, "48624650", managerRole, Gender.MALE);
        UserDTO user3 = new UserDTO("Emre3", "Cihan","emre.cihan3@gmail.com", "a123", true, "48624650", employeeRole, Gender.MALE);
        UserDTO user4 = new UserDTO("Emre4", "Cihan","emre.cihan4@gmail.com", "a123", true, "48624650", managerRole, Gender.MALE);
        UserDTO user5 = new UserDTO("Emre5", "Cihan","emre.cihan5@gmail.com", "a123", true, "48624650", employeeRole, Gender.MALE);
        UserDTO user6 = new UserDTO("Emre6", "Cihan","emre.cihan6@gmail.com", "a123", true, "48624650", managerRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);


        ProjectDTO project1 = new ProjectDTO("Cypress project", "001", user1, LocalDate.of(2021, 10, 4), LocalDate.of(2024, 10, 4), "nothing", Status.ONGOING);
        ProjectDTO project2 = new ProjectDTO("Java project", "002", user2, LocalDate.of(2021, 10, 4), LocalDate.of(2024, 10, 4), "nothing", Status.FINISHED);
        ProjectDTO project3 = new ProjectDTO("Rest Assured project", "003", user3, LocalDate.of(2021, 10, 4), LocalDate.of(2024, 10, 4), "nothing", Status.FINISHED);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);


        TaskDTO task1 = new TaskDTO(project1, user1, "generating report", "generating report detail", LocalDate.of(2024, 1, 1), Status.ONGOING);
        TaskDTO task2 = new TaskDTO(project2, user1, "parallelization", "parallelization report detail", LocalDate.of(2024, 1, 1), Status.ONGOING);
        TaskDTO task3 = new TaskDTO(project3, user2, "integration to test management tool", "integration to test management tool detail", LocalDate.of(2024, 1, 1), Status.FINISHED);
        TaskDTO task4 = new TaskDTO( project3, user3, "integration to MS Teams", "integration to MS Teams detail", LocalDate.of(2024, 1, 1), Status.ONGOING);


        taskService.save(task1);
        taskService.save(task2);
        taskService.save(task3);
        taskService.save(task4);

    }
}
