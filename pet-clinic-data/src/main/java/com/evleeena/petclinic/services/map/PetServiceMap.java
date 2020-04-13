package com.evleeena.petclinic.services.map;

import com.evleeena.petclinic.model.Pet;
import com.evleeena.petclinic.services.PetService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }
}
