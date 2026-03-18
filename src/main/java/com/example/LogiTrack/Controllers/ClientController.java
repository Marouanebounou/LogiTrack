package com.example.LogiTrack.Controllers;


import com.example.LogiTrack.Models.Client;
import com.example.LogiTrack.Services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public List<Client> getAll()
    {
        return clientService.getAllClients();
    }

    @PostMapping("/new")
    public Client createClient(@RequestBody Client client)
    {
        return clientService.addClient(client);
    }

    @GetMapping("/get/{id}")
    public Optional<Client> getClient(@PathVariable int id)
    {
        return clientService.getClientById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClient(@PathVariable int id)
    {
        clientService.deleteClient(id);
        return "Client deleted successfully";
    }

}
