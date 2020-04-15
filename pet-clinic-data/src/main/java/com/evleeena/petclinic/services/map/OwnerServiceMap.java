package com.evleeena.petclinic.services.map;

import com.evleeena.petclinic.model.Owner;
import com.evleeena.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        if (StringUtils.isEmpty(lastName)) {
            return null;
        }

        return this.findAll().stream()
                .filter(owner -> lastName.equals(owner.getLastName()))
                .findFirst().orElse(null);
    }
}
