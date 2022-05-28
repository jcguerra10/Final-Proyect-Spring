package com.icesi.store.finalproyect.services.interfaces;

import com.icesi.store.finalproyect.model.Client;

import java.util.Optional;

public interface ClientServiceI {
    public Client addClient(Client client);
    public Client updateClient(Client client, Integer idToUpdate);
    public void removeClient(Integer idToRemove);

    Iterable<Client> findAll();

    Optional<Client> findById(Integer id);
}
