package com.example.deneme3.controller;

import com.example.deneme3.DTO.UserDTO;
import com.example.deneme3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserDTO register(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);//kullanıcı kaydı.
    }

    @GetMapping("/{username}")
    public UserDTO getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);//belirli bir kullanıcı adına sahip kullanıcıyı getir.
    }
}
