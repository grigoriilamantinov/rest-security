package com.security.securityrest.authority.services;

import com.security.securityrest.authority.dao.AuthoritiesRepository;
import com.security.securityrest.authority.dto.AuthorityWithoutUser;
import com.security.securityrest.authority.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    private final AuthoritiesRepository authoritiesRepository;

    public AuthorityServiceImpl(
        @Autowired AuthoritiesRepository authoritiesRepository
    ) {
        this.authoritiesRepository = authoritiesRepository;
    }

    @Override
    public List<AuthorityWithoutUser> getAll() {
        return authoritiesRepository.findAll().stream()
            .map(authority -> AuthorityWithoutUser.of(authority))
            .collect(Collectors.toList());
    }

    @Override
    public void save(AuthorityWithoutUser auth) {

    }

    @Override
    public AuthorityWithoutUser getById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
