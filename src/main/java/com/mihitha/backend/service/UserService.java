package com.mihitha.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mihitha.backend.dto.UserPwdDto;
import com.mihitha.backend.entity.User;

@Service
public interface UserService {

    List<User> getAllUsers();
    User createUser(User user);
    User getUserById(Long id);
    User changeUserPassword(Long id, UserPwdDto userPwdDto);
    
}
