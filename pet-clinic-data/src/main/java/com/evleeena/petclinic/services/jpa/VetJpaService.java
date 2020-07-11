package com.evleeena.petclinic.services.jpa;

import com.evleeena.petclinic.model.Vet;
import com.evleeena.petclinic.repositories.VetRepository;
import com.evleeena.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class VetJpaService implements VetService {

    @Resource
    private VetRepository vetRepository;

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
