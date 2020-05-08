package com.evleeena.petclinic.services.map;

import com.evleeena.petclinic.model.PetType;
import com.evleeena.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}
