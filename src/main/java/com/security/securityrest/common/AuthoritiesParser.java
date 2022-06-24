package com.security.securityrest.common;

import com.security.securityrest.authority.entity.Authority;
import com.security.securityrest.authority.services.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthoritiesParser {
    public AuthorityService authorityService;

    public AuthoritiesParser(
        @Autowired final AuthorityService authorityService
    ) {
        this.authorityService = authorityService;
    }

    public List<Authority> parsToList(final List<String> userRolesNumberRepresentation) {
        return userRolesNumberRepresentation.stream()
            .map(roleId -> authorityService.getById(Integer.parseInt(roleId)))
            .collect(Collectors.toList());
    }
}
