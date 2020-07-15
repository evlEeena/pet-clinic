package com.evleeena.petclinic.services.map;

import com.evleeena.petclinic.model.Vet;
import com.evleeena.petclinic.services.SpecialityService;
import com.evleeena.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

@Service
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    @Resource
    private SpecialityService specialityService;

    @Override
    public Vet save(Vet object) {
        if (object == null) {
            return null;
        }

        if (!CollectionUtils.isEmpty(object.getSpecialities())) {
            object.getSpecialities().stream().filter(speciality -> speciality.getId() == null).forEach(speciality -> specialityService.save(speciality));
        }

        return super.save(object);
    }
}
