package com.jexk.identity_service.service;

import com.jexk.identity_service.dto.request.UserCreationRequest;
import com.jexk.identity_service.entity.User;
import com.jexk.identity_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }


    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")) ;
    }
}
