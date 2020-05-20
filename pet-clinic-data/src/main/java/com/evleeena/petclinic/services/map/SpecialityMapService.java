package com.evleeena.petclinic.services.map;

import com.evleeena.petclinic.model.Speciality;
import com.evleeena.petclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {
}
