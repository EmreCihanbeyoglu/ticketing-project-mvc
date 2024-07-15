package com.cydeo.dto;

import com.cydeo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
public class TaskDTO {

    private Long id;
    private ProjectDTO project;
    private UserDTO employee;
    private String subject;
    private String taskDetail;
    private LocalDate assignedDate;
    private Status taskStatus;

    public TaskDTO(ProjectDTO project, UserDTO employee, String subject, String taskDetail, LocalDate assignedDate, Status taskStatus) {
        this.project = project;
        this.taskStatus = taskStatus;
        this.taskDetail = taskDetail;
        this.assignedDate = assignedDate;
        this.subject = subject;
        this.employee = employee;
        this.id = UUID.randomUUID().getMostSignificantBits();
    }
}
