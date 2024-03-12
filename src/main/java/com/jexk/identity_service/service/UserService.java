package com.jexk.identity_service.service;

import com.jexk.identity_service.dto.request.UserCreationRequest;
import com.jexk.identity_service.dto.request.UserUpdateRequest;
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

        if (userRepository.existsByUsername(request.getUsername()))
            throw new RuntimeException("user not exist !");

        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }


    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String userId, UserUpdateRequest request) {
        User user = getUserById(userId);
        user.setFirstName(request.getFirstName());
        user.setDob(request.getDob());

        return user;
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
