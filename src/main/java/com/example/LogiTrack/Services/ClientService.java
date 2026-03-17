package com.example.LogiTrack.Services;

import com.example.LogiTrack.Models.Client;
import com.example.LogiTrack.Repositories.ClientRepositorie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepositorie clientRepositorie;

    public ClientService(ClientRepositorie clientRepositorie)
    {
        this.clientRepositorie = clientRepositorie;
    }

    public void addClient(Client client)
    {
        clientRepositorie.save(client);
    }
    
    public List<Client> getAllClients(){
        return clientRepositorie.findAll();
    }
    
    public Optional<Client> getClientById(int id)
    {
        return clientRepositorie.findById(id);
    }

    public void deleteClient(Client client)
    {
        clientRepositorie.delete(client);
    }
}
