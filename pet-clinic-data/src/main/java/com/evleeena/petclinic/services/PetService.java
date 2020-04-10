package com.evleeena.petclinic.services;

import com.evleeena.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Set<Pet> findAll();

    Pet save(Pet pet);
}
