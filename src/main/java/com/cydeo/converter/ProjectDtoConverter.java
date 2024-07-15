package com.cydeo.converter;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.service.IProjectService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class ProjectDtoConverter implements Converter<String, ProjectDTO> {

    IProjectService projectService;

    public ProjectDtoConverter(IProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public ProjectDTO convert(String projectCode) {
        return projectService.findById(projectCode);
    }
}
