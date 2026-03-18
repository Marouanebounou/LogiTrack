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

    public Client addClient(Client client)
    {
       return clientRepositorie.save(client);
    }
    
    public List<Client> getAllClients(){
        return clientRepositorie.findAll();
    }
    
    public Optional<Client> getClientById(int id)
    {
        return clientRepositorie.findById(id);
    }

    public void deleteClient(int id)
    {
        Client client1 = clientRepositorie.findById(id).orElseThrow(IllegalArgumentException::new);
        clientRepositorie.delete(client1);
    }
}
