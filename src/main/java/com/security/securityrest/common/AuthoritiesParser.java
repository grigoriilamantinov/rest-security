package com.security.securityrest.common;

import com.security.securityrest.authority.entity.Authority;
import com.security.securityrest.authority.services.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static List<Authority> parsToList(List<String> stringXML) {
        List<Authority> listAuthority = new ArrayList<>();

        for (String role : stringXML) {
            Integer id = Integer.parseInt(role);
            var add  = authorityService.getById(id);
            listAuthority.add(add);
//            new Authority(id, add.getRole())
        }
        return listAuthority;
    }
}
