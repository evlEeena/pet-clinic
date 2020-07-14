package com.evleeena.petclinic.services.jpa;

import com.evleeena.petclinic.model.Vet;
import com.evleeena.petclinic.repositories.VetRepository;
import com.evleeena.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("jpa")
public class VetJpaService implements VetService {

    @Resource
    private VetRepository vetRepository;

    @Override
    @Transactional
    public Set<Vet> findAll() {
        return StreamSupport.stream(vetRepository.findAll().spliterator(), false)
                .peek(vet -> vet.getSpecialities().size())
                .collect(Collectors.toSet());
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
