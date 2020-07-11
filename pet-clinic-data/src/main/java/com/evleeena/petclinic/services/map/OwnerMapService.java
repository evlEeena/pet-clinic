package com.evleeena.petclinic.services.map;

import com.evleeena.petclinic.model.Owner;
import com.evleeena.petclinic.model.Pet;
import com.evleeena.petclinic.services.OwnerService;
import com.evleeena.petclinic.services.PetService;
import com.evleeena.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    @Resource
    private PetTypeService petTypeService;
    @Resource
    private PetService petService;

    @Override
    public Owner findByLastName(String lastName) {
        if (StringUtils.isEmpty(lastName)) {
            return null;
        }

        return this.findAll().stream()
                .filter(owner -> lastName.equals(owner.getLastName()))
                .findFirst().orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        if (object == null) {
            return null;
        }

        if (!CollectionUtils.isEmpty(object.getPets())) {
            boolean isTypeEmpty = object.getPets().stream().anyMatch(pet -> pet.getPetType() == null);
            if (isTypeEmpty) {
                throw new IllegalStateException("Pet Type is required!");
            }

            object.getPets().stream().map(Pet::getPetType)
                    .filter(petType -> petType.getId() == null).forEach(type-> petTypeService.save(type));

            object.getPets().stream().filter(pet -> pet.getId() == null).forEach(pet -> petService.save(pet));
        }

        return super.save(object);
    }
}
