package ma.emsi.aeroproject.service;

import ma.emsi.aeroproject.dao.entities.Client;

import java.util.List;

public interface ClientManager {
    Client addClient(Client client);

    Client updateClient(Client client);

    boolean deleteClient(Client client);

    Client getClientById(Integer id);

    boolean deleteClientByID(Integer id);

    List<Client> getAllClients();
}
