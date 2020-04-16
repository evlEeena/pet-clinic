package com.evleeena.petclinic.services.map;

import com.evleeena.petclinic.model.Vet;
import com.evleeena.petclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
}
