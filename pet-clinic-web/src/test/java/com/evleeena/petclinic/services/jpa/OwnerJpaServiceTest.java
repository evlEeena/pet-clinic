package com.evleeena.petclinic.services.jpa;

import com.evleeena.petclinic.model.Owner;
import com.evleeena.petclinic.repositories.OwnerRepository;
import com.evleeena.petclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerJpaService ownerService;

    private Owner returnedOwner;

    private final String LAST_NAME = "Smith";

    @BeforeEach
    void setUp() {
        returnedOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);

        Owner owner = ownerService.findByLastName(LAST_NAME);
        assertNotNull(owner);
        assertEquals(LAST_NAME, owner.getLastName());
    }

    @Test
    void findAll() {
        Owner owner2 = Owner.builder().id(2L).lastName("Zaets").build();

        Set<Owner> returnedOwners = new HashSet<>();
        returnedOwners.add(returnedOwner);
        returnedOwners.add(owner2);

        when(ownerRepository.findAll()).thenReturn(returnedOwners);

        Set<Owner> owners = ownerService.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnedOwner));

        Owner owner = ownerService.findById(1L);
        assertNotNull(owner);
        assertEquals(1L, owner.getId());
    }

    @Test
    void save() {
        Owner savedOwner = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnedOwner);

        Owner owner = ownerService.save(savedOwner);
        assertNotNull(owner);
        assertEquals(1L, owner.getId());
    }

    @Test
    void delete() {
        ownerService.delete(returnedOwner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(returnedOwner.getId());

        verify(ownerRepository).deleteById(any());

    }
}