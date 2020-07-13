package com.evleeena.petclinic.bootstrap;

import com.evleeena.petclinic.model.*;
import com.evleeena.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;

@Component
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
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Pet types: " + savedDogPetType + ", " + savedCatPetType);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1253123123");

        Pet mikesPet = new Pet();
        mikesPet.setName("Rosco");
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setBirthDate(LocalDate.of(2018, 1, 8));
        mikesPet.setOwner(owner1);

        owner1.getPets().add(mikesPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("213321345");

        Pet fionasPet = new Pet();
        fionasPet.setName("Kiko");
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setBirthDate(LocalDate.of(2016, 5, 23));
        fionasPet.setOwner(owner2);

        owner2.getPets().add(fionasPet);

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loaded Pets...");
        System.out.println(petService.findAll());

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

        // todo fix lazy init exception
        System.out.println("Loaded Vets... ");
        System.out.println(vetService.findAll());

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

        System.out.println("Loaded visits: " + visitService.findAll());
    }
}
