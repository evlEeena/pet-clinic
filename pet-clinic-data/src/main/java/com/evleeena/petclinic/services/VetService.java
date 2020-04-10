package com.evleeena.petclinic.services;

import com.evleeena.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);

    Set<Vet> findAll();

    Vet save(Vet pet);
}
