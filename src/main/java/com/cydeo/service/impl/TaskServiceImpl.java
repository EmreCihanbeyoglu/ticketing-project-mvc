package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.IProjectService;
import com.cydeo.service.ITaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements ITaskService {

    IProjectService projectService;

    public TaskServiceImpl(IProjectService projectService) {
        this.projectService = projectService;
    }


    @Override
    public TaskDTO save(TaskDTO task) {

        if(task.getTaskStatus() == null) {
            task.setTaskStatus(Status.ONGOING);
        }

        if(task.getAssignedDate() == null) {
            task.setAssignedDate(LocalDate.now());
        }

        if(task.getId() == null) {
            task.setId(UUID.randomUUID().getMostSignificantBits());
        }

        return super.save(task.getId(), task);
    }

    @Override
    public TaskDTO findById(Long taskId) {
        return super.findById(taskId);
    }

    @Override
    public void deleteById(Long taskId) {
        super.deleteById(taskId);
    }

    @Override
    public TaskDTO update(TaskDTO task) {

        TaskDTO existingTask = findById(task.getId());
        System.out.println("existing task: " + existingTask);
        System.out.println("new task: " + task);
        task.setAssignedDate(existingTask.getAssignedDate());
        task.setTaskStatus(existingTask.getTaskStatus());
        return super.update(task.getId(), task);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }


    @Override
    public List<TaskDTO> getFinishedTaskList() {
        return findAll().stream().filter(task -> task.getTaskStatus() == Status.FINISHED).collect(Collectors.toList());
    }


    @Override
    public List<TaskDTO> getUnfinishedTaskList() {
        return findAll().stream().filter(task -> task.getTaskStatus() != Status.FINISHED).collect(Collectors.toList());
    }

    @Override
    public Map<ProjectDTO, List<TaskDTO>> getFinishedTasksGroupedByProject() {
        Map<ProjectDTO, List<TaskDTO>> taskAndProjectMap = getFinishedTaskList().stream().collect(Collectors.groupingBy(TaskDTO::getProject));
        projectService.findAll().forEach(project -> {
            if(!taskAndProjectMap.containsKey(project)) {
                taskAndProjectMap.put(project, new ArrayList<>());
            }
        });

        return taskAndProjectMap;
    }

    @Override
    public Map<ProjectDTO, List<TaskDTO>> getUnfinishedTasksGroupedByProject() {
        Map<ProjectDTO, List<TaskDTO>> taskAndProjectMap = getUnfinishedTaskList().stream().collect(Collectors.groupingBy(TaskDTO::getProject));
        projectService.findAll().forEach(project -> {
            if(!taskAndProjectMap.containsKey(project)) {
                taskAndProjectMap.put(project, new ArrayList<>());
            }
        });

        return taskAndProjectMap;
    }

}
