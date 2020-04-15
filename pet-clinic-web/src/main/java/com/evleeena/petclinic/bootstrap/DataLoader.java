package com.evleeena.petclinic.bootstrap;

import com.evleeena.petclinic.model.Owner;
import com.evleeena.petclinic.model.Vet;
import com.evleeena.petclinic.services.OwnerService;
import com.evleeena.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class DataLoader implements CommandLineRunner {

    @Resource
    private OwnerService ownerService;
    @Resource
    private VetService vetService;

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");
        System.out.println(ownerService.findAll());

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loaded Vets... ");
        System.out.println(vetService.findAll());
    }
}
