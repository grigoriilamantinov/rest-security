package com.security.soapcrud.authority.services;

import com.security.soapcrud.authority.dao.AuthoritiesRepository;
import com.security.soapcrud.authority.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    private final AuthoritiesRepository authoritiesRepository;

    public AuthorityServiceImpl(
        @Autowired AuthoritiesRepository authoritiesRepository
    ) {
        this.authoritiesRepository = authoritiesRepository;
    }

    @Override
    public Authority getById(final int id) {
        return authoritiesRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException(
                String.format("No element with id = %s in authority database", id)));
    }
}
