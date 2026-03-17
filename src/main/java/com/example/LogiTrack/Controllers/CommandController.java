package com.example.LogiTrack.Controllers;

import com.example.LogiTrack.Models.Commande;
import com.example.LogiTrack.Services.CommandService;
import com.example.LogiTrack.Services.LigneCommandeService;
import com.example.LogiTrack.enums.StatutCommande;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/commande")
public class CommandController {
    private final CommandService commandService;
    private final LigneCommandeService ligneCommandeService;

    public CommandController(CommandService commandService , LigneCommandeService ligneCommandeService)
    {
        this.commandService = commandService;
        this.ligneCommandeService = ligneCommandeService;
    }

    @GetMapping("/all")
    public List<Commande> getAllCommands()
    {
        return commandService.getAllCommandes();
    }

    @GetMapping("/{id}")
    public Optional<Commande> getCommandById(@PathVariable int id)
    {
        return commandService.findCommande(id);
    }

    @PutMapping("/update/{id}/{status}")
    public String updateCommandeStatus(@PathVariable int id ,@PathVariable StatutCommande status)
    {
        commandService.updateCommandeStatus(id , status);
        return "Command updated successfully";
    }

    @PostMapping("/add/{orderId}/{ligneId}/{productId}")
    public String addProduct(@PathVariable int orderId , @PathVariable int ligneId , @PathVariable int productId)
    {
        ligneCommandeService.addLigneCommande(productId , ligneId , orderId);
        return "Product added successfully";
    }
}
