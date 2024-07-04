package com.cydeo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Project extends BaseModel{

    private String projectName;
    private String projectCode;
    private String assignedManager;
    private LocalDate startDate;
    private LocalDate endDate;
    private String projectDetail;
    private String status;

    public Project(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserId, String projectName, String projectCode, String assignedManager, LocalDate startDate, LocalDate endDate, String projectDetail) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.assignedManager = assignedManager;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectDetail = projectDetail;
    }
}
