package com.example.deneme3.service;

import com.example.deneme3.DTO.UserDTO;
import com.example.deneme3.model.User;
import com.example.deneme3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO save(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        user.setId(UUID.randomUUID().toString());
        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    public UserDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return convertToDTO(user);
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
}
