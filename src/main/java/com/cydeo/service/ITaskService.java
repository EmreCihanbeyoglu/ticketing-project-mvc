package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;

import java.util.List;
import java.util.Map;

public interface ITaskService extends ICrudService<TaskDTO, Long>{

    List<TaskDTO> getFinishedTaskList();

    List<TaskDTO> getUnfinishedTaskList();

    Map<ProjectDTO, List<TaskDTO>> getFinishedTasksGroupedByProject();

    Map<ProjectDTO, List<TaskDTO>> getUnfinishedTasksGroupedByProject();
}
