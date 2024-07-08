package com.cydeo.converter;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.IUserService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class UserDtoConverter implements Converter<String, UserDTO> {

    IUserService userService;

    public UserDtoConverter(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO convert(String username) {
        return userService.findById(username);
    }
}
