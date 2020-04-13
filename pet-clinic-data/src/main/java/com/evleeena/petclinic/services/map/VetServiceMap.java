package com.evleeena.petclinic.services.map;

import com.evleeena.petclinic.model.Vet;
import com.evleeena.petclinic.services.VetService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }
}
