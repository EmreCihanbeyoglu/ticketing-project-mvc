package com.cydeo.bootstrap;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.service.IRoleService;
import com.cydeo.service.IUserService;
import com.cydeo.service.impl.RoleServiceImpl;
import com.cydeo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    IRoleService roleService;
    IUserService userService;


    public DataGenerator(IRoleService roleService, IUserService userService) {
        this.roleService = roleService;
        this.userService = userService;
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
        UserDTO user3 = new UserDTO("Emre3", "Cihan","emre.cihan3@gmail.com", "a123", true, "48624650", managerRole, Gender.MALE);
        UserDTO user4 = new UserDTO("Emre4", "Cihan","emre.cihan4@gmail.com", "a123", true, "48624650", managerRole, Gender.MALE);
        UserDTO user5 = new UserDTO("Emre5", "Cihan","emre.cihan5@gmail.com", "a123", true, "48624650", managerRole, Gender.MALE);
        UserDTO user6 = new UserDTO("Emre6", "Cihan","emre.cihan6@gmail.com", "a123", true, "48624650", managerRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);

    }
}
