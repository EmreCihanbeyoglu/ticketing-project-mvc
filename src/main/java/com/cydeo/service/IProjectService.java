package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;

import java.util.List;

public interface IProjectService extends ICrudService<ProjectDTO, String>{

    void completeProjectById(String projectCode);
}
