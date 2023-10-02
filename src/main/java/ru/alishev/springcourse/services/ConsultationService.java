package ru.alishev.springcourse.services;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alishev.springcourse.models.Client;
import ru.alishev.springcourse.models.Consultation;
import ru.alishev.springcourse.repositories.ConsultationRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ConsultationService {
    private final ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    @Transactional
    public void save(Consultation consultation) {
        consultationRepository.save(consultation);
    }

    @Transactional
    public void update(int id, Consultation consultation) {
        consultation.setConsultationId(id);
        consultationRepository.save(consultation);
    }

    @Transactional
    public void delete(int id) {
        consultationRepository.deleteById(id);
    }

    public Consultation findOne(int id) {
        Optional<Consultation> foundPerson = consultationRepository.findById(id);
        return foundPerson.orElse(null);
    }



}
