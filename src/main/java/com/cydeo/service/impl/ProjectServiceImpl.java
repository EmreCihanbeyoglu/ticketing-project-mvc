package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.IProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements IProjectService {

    @Override
    public ProjectDTO save(ProjectDTO project) {
        if(project.getStatus() == null) {
            project.setStatus(Status.ONGOING);
        }
        return super.save(project.getProjectCode(), project);
    }

    @Override
    public ProjectDTO update(ProjectDTO project) {
        // we need to make sure that the fields which are not
        // present in the view will remain unchanged after update
        // status is one of them
        if(project.getStatus() == null) {
            project.setStatus(super.findById(project.getProjectCode()).getStatus());
        }
        super.update(project.getProjectCode(), project);
        return findById(project.getProjectCode());
    }

    @Override
    public ProjectDTO findById(String projectCode) {
        return super.findById(projectCode);
    }

    @Override
    public void deleteById(String projectCode) {
        super.deleteById(projectCode);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }


    @Override
    public void completeProjectById(String projectCode) {
        ProjectDTO project = super.findById(projectCode);
        if(!project.getStatus().equals(Status.FINISHED)) {
            project.setStatus(Status.FINISHED);
        }
    }

}
