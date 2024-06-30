package com.cydeo.converter;

import com.cydeo.dto.RoleDTO;
import com.cydeo.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding // conversion is done automatically by Spring
public class RoleDtoConverter implements Converter<String, RoleDTO> {

    @Autowired
    IRoleService roleService;

    @Override
    public RoleDTO convert(String source) {
        return roleService.findById(Long.parseLong(source));
    }
}
