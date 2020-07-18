package com.evleeena.petclinic.bootstrap;

import com.evleeena.petclinic.model.*;
import com.evleeena.petclinic.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Set;

@Component
@Slf4j
public class DataLoader implements CommandLineRunner {

    @Resource
    private OwnerService ownerService;
    @Resource
    private VetService vetService;
    @Resource
    private PetTypeService petTypeService;
    @Resource
    private PetService petService;
    @Resource
    private SpecialityService specialityService;
    @Resource
    private VisitService visitService;

    @Override
    public void run(String... args) {
        if (petService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = PetType.builder().name("Dog").build();
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = PetType.builder().name("Cat").build();
        PetType savedCatPetType = petTypeService.save(cat);

        log.debug("Pet types: {}, {}", savedDogPetType, savedCatPetType);

        Owner owner1 = Owner.builder().firstName("Michael").lastName("Weston")
                .address("123 Brickerel").city("Miami").telephone("1253123123").build();

        Pet mikesPet = Pet.builder().name("Rosco").petType(savedDogPetType)
                .birthDate(LocalDate.of(2018, 1, 8)).owner(owner1).build();
        owner1.getPets().add(mikesPet);

        Owner owner2 = Owner.builder().firstName("Fiona").lastName("Glenanne")
                .address("123 Brickerel").city("Miami").telephone("213321345").build();

        Pet fionasPet = Pet.builder().name("Kiko").petType(savedCatPetType)
                .birthDate(LocalDate.of(2016, 5, 23)).owner(owner2).build();
        owner2.getPets().add(fionasPet);

        ownerService.save(owner1);
        ownerService.save(owner2);

        log.debug("Loaded Pets...\n {}", petService.findAll());

        Speciality radiology = Speciality.builder().description("Radiology").build();
        Speciality surgery = Speciality.builder().description("Surgery").build();
        Speciality dentistry = Speciality.builder().description("Dentistry").build();

        specialityService.save(radiology);
        specialityService.save(surgery);
        specialityService.save(dentistry);

        Vet vet1 = Vet.builder().firstName("Sam").lastName("Axe")
                .specialities(Set.of(radiology)).build();

        Vet vet2 = Vet.builder().firstName("Jessie").lastName("Porter")
                .specialities(Set.of(surgery)).build();

        vetService.save(vet1);
        vetService.save(vet2);

        log.debug("Loaded Vets... \n{}", vetService.findAll());

        Visit roscoVisit = Visit.builder().pet(mikesPet).date(LocalDate.now())
                .description("Rosco's castration").build();

        Visit kikoVisit = Visit.builder().pet(fionasPet).date(LocalDate.now())
                .description("Kiko's vaccination").build();

        visitService.save(roscoVisit);
        visitService.save(kikoVisit);

        mikesPet.getVisits().add(roscoVisit);
        fionasPet.getVisits().add(kikoVisit);

        petService.save(mikesPet);
        petService.save(fionasPet);

        log.debug("Loaded visits: {}", visitService.findAll());
    }
}
