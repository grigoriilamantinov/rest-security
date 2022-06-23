package com.security.securityrest.common;

import com.security.securityrest.authority.entity.Authority;
import com.security.securityrest.authority.services.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthoritiesParser {
    public static AuthorityService authorityService;

    public AuthoritiesParser(
        @Autowired AuthorityService authorityService
    ) {
        AuthoritiesParser.authorityService = authorityService;
    }

    public static List<Authority> parsToList(final List<String> stringXML) {
        return stringXML.stream()
            .map(roleId -> authorityService.getById(Integer.parseInt(roleId)))
            .collect(Collectors.toList());
    }
}
