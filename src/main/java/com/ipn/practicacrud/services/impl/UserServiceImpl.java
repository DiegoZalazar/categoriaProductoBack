package com.ipn.practicacrud.services.impl;

import com.ipn.practicacrud.models.User;
import com.ipn.practicacrud.repository.Usuario.UserRepository;
import com.ipn.practicacrud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User RegisterUser(User user) {
        return userRepository.save(user);
    }
}
