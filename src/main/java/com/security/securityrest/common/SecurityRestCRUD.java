package com.security.securityrest.common;

import java.util.List;

public interface SecurityRestCRUD<E> {

    public List<E> getAll();

    public void save(E e);

    public E getById(int id);

    public void delete(int id);
}
