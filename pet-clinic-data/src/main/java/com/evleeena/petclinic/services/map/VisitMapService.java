package com.evleeena.petclinic.services.map;

import com.evleeena.petclinic.model.Visit;
import com.evleeena.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
}
