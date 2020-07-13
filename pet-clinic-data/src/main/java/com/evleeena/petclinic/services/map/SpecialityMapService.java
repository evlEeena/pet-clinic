package com.evleeena.petclinic.services.map;

import com.evleeena.petclinic.model.Speciality;
import com.evleeena.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {
}
