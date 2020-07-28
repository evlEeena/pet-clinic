package com.evleeena.petclinic.services.map;

import com.evleeena.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;

    private final Long id = 1L;
    private final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(id).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertNotNull(owners);
        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(id);
        assertNotNull(owner);
        assertEquals(1, owner.getId());
    }

    @Test
    void saveWithId() {
        Owner newOwner = Owner.builder().id(2L).build();
        Owner savedOwner = ownerMapService.save(newOwner);
        assertNotNull(savedOwner);
        assertEquals(2L, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner newOwner = Owner.builder().build();
        Owner savedOwner = ownerMapService.save(newOwner);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(id));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(id);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);
        assertNotNull(owner);
        assertEquals(lastName, owner.getLastName());
    }
}