package ru.alishev.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alishev.springcourse.models.Client;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {



}
