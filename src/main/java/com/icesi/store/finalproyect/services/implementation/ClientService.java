package com.icesi.store.finalproyect.services.implementation;

import com.icesi.store.finalproyect.model.Client;
import com.icesi.store.finalproyect.repositories.ClientRepository;
import com.icesi.store.finalproyect.services.interfaces.ClientServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ClientService implements ClientServiceI {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public Client updateClient(Client client, Integer idToUpdate) {
        Client toUpdate = clientRepository.findById(idToUpdate).get();
        toUpdate.setName(client.getName());
        toUpdate.setStore(client.getStore());
        return clientRepository.save(toUpdate);
    }

    @Override
    @Transactional
    public void removeClient(Integer idToRemove) {
        Client toRemove = clientRepository.findById(idToRemove).get();
        clientRepository.delete(toRemove);
    }

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return clientRepository.findById(id);
    }
}
