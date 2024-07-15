package com.cydeo.model;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Task extends BaseModel{

    private ProjectDTO project;
    private UserDTO employee;
    private String subject;
    private String taskDetail;

    public Task(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserId, ProjectDTO project, UserDTO employee, String subject, String taskDetail) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.project = project;
        this.employee = employee;
        this.subject = subject;
        this.taskDetail = taskDetail;
    }
}
