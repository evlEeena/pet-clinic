package com.evleeena.petclinic.services.map;

import com.evleeena.petclinic.model.Pet;
import com.evleeena.petclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
}
