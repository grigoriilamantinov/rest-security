package com.security.securityrest.authority.controllers;

import com.security.securityrest.authority.dto.AuthorityWithoutUser;
import com.security.securityrest.authority.entity.Authority;
import com.security.securityrest.authority.services.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class controllerREST {
    private final AuthorityService authorityService;

    public controllerREST(
        @Autowired final AuthorityService authorityService
    ) {
        this.authorityService = authorityService;
    }

    @GetMapping()
    public List<AuthorityWithoutUser> showAllRoles() {
        return authorityService.getAll();
    }
}
