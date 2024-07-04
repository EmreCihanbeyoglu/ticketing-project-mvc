package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends AbstractMapService<UserDTO, String> implements IUserService {
    @Override
    public UserDTO save(UserDTO user) {
        return super.save(user.getUsername(), user);
    }

    @Override
    public UserDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public UserDTO update(UserDTO object) {
        return super.update(object.getUsername(), object);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

}
