package ma.emsi.aeroproject.service;

import ma.emsi.aeroproject.dao.entities.Client;
import ma.emsi.aeroproject.dao.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService implements ClientManager {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client addClient(Client client) {
        try {
            return clientRepository.save(client);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public Client updateClient(Client client) {
        try {
            return clientRepository.save(client);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteClient(Client client) {
        try {
            clientRepository.delete(client);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public boolean deleteClientByID(Integer id) {
        try {
            clientRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
    @Override
    public Client getClientById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }
}
