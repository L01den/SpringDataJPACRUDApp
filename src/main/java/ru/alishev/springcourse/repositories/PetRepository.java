package ru.alishev.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alishev.springcourse.models.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
