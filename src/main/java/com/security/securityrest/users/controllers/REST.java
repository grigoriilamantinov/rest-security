package com.security.securityrest.users.controllers;

import com.security.securityrest.users.dto.UserWithNameDTO;
import com.security.securityrest.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class REST {
    UserService userService;

    public REST(
        @Autowired UserService userService
    ) {
        this.userService = userService;
    }

    @RequestMapping()
    public List<UserWithNameDTO> showAll() {
        return userService.getAllUserWithName();
    }
}
