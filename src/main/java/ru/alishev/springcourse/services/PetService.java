package ru.alishev.springcourse.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alishev.springcourse.models.Client;
import ru.alishev.springcourse.models.Consultation;
import ru.alishev.springcourse.models.Pet;
import ru.alishev.springcourse.repositories.PetRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Transactional
    public void save(Pet pet) {
        petRepository.save(pet);
    }

    @Transactional
    public void update(int id, Pet updatedPet) {
        updatedPet.setPetId(id);
        petRepository.save(updatedPet);
    }

    @Transactional
    public void delete(int id) {
        petRepository.deleteById(id);
    }

    public Pet findOne(int id) {
        Optional<Pet> foundPerson = petRepository.findById(id);
        return foundPerson.orElse(null);
    }

}
