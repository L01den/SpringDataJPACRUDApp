package ru.alishev.springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alishev.springcourse.models.Client;
import ru.alishev.springcourse.models.Consultation;
import ru.alishev.springcourse.repositories.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ClientServices {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServices(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Transactional
    public void update(int id, Client client) {
        client = clientRepository.findById(id).get();
        client.setClientId(id);

        clientRepository.save(client);
    }

    public Client findOne(int id) {
        Optional<Client> foundPerson = clientRepository.findById(id);
        return foundPerson.orElse(null);
    }


    @Transactional
    public void delete(int id) {
        clientRepository.deleteById(id);
    }
}


