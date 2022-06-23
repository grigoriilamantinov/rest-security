package com.security.securityrest.authority.services;

import com.security.securityrest.authority.dto.AuthorityWithoutUser;
import com.security.securityrest.authority.entity.Authority;

import java.util.List;

public interface AuthorityService {
    List<AuthorityWithoutUser> getAll();

    Authority getById(int id);
}
