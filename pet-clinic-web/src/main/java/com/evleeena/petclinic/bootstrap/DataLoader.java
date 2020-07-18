package com.evleeena.petclinic.bootstrap;

import com.evleeena.petclinic.model.*;
import com.evleeena.petclinic.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;

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

        Pet fionasPet = Pet.builder().name().petType().birthDate().owner().build();
        fionasPet.setName("Kiko");
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setBirthDate(LocalDate.of(2016, 5, 23));
        fionasPet.setOwner(owner2);

        owner2.getPets().add(fionasPet);

        ownerService.save(owner1);
        ownerService.save(owner2);

        log.debug("Loaded Pets...\n {}", petService.findAll());

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");

        specialityService.save(radiology);
        specialityService.save(surgery);
        specialityService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(radiology);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(surgery);

        vetService.save(vet1);
        vetService.save(vet2);

        log.debug("Loaded Vets... \n{}", vetService.findAll());

        Visit roscoVisit = new Visit();
        roscoVisit.setPet(mikesPet);
        roscoVisit.setDate(LocalDate.now());
        roscoVisit.setDescription("Rosco's castration");

        Visit kikoVisit = new Visit();
        kikoVisit.setPet(fionasPet);
        kikoVisit.setDate(LocalDate.now());
        kikoVisit.setDescription("Kiko's vaccination");

        visitService.save(roscoVisit);
        visitService.save(kikoVisit);

        log.debug("Loaded visits: {}", visitService.findAll());
    }
}
