package com.evleeena.petclinic.services.map;

import com.evleeena.petclinic.model.PetType;
import com.evleeena.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default","map"})
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}
