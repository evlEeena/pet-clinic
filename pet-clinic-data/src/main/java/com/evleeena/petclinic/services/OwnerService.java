package com.evleeena.petclinic.services;

import com.evleeena.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findById(Long id);

    Owner findByLastName(String latName);

    Set<Owner> findAll();

    Owner save(Owner owner);
}
