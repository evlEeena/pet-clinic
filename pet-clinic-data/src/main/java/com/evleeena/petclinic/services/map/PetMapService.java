package com.evleeena.petclinic.services.map;

import com.evleeena.petclinic.model.Pet;
import com.evleeena.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default","map"})
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
}
