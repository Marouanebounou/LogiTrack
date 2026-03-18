package com.example.LogiTrack.Services;

import com.example.LogiTrack.Models.Commande;
import com.example.LogiTrack.Models.LigneCommande;
import com.example.LogiTrack.Models.Product;
import com.example.LogiTrack.Repositories.CommandRepositorie;
import com.example.LogiTrack.Repositories.LigneCommandeRepositorie;
import com.example.LogiTrack.Repositories.ProductRepositorie;
import com.example.LogiTrack.enums.StatutCommande;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CommandService {
    private final CommandRepositorie commandRepositorie;
    private final ProductRepositorie productRepositorie;
    private final LigneCommandeRepositorie ligneCommandeRepositorie;

    public CommandService(CommandRepositorie commandRepositorie , ProductRepositorie productRepositorie, LigneCommandeRepositorie ligneCommandeRepositorie)
    {
        this.commandRepositorie = commandRepositorie;
        this.productRepositorie = productRepositorie;
        this.ligneCommandeRepositorie = ligneCommandeRepositorie;
    }

    public Commande addCommand(Commande commande)
    {
        return commandRepositorie.save(commande);
    }

    public List<Commande> getAllCommandes()
    {
        return commandRepositorie.findAll();
    }

    public List<Commande> getClientCommandes(int id)
    {
        return commandRepositorie.findAllByClientId(id);
    }

    public Commande findCommande(int id)
    {
        return commandRepositorie.findById(id).orElseThrow(()-> new RuntimeException("Command not found"));
    }

    public void updateCommandeStatus(int id , StatutCommande statutCommande)
    {
        Commande commande = commandRepositorie.findById(id).orElseThrow(IllegalArgumentException::new);
        commande.setStatutCommande(statutCommande);
        commandRepositorie.save(commande);
    }

    @Transactional
    public void addProductToCommand(int productId , int CommandeId , int quantity)
    {
        Commande commande = commandRepositorie.findById(CommandeId).orElseThrow(() -> new RuntimeException("Command not found"));
        Product product = productRepositorie.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getQuantity() < quantity){
            throw new RuntimeException("Not enough stock");
        }

        product.setQuantity(product.getQuantity() - quantity);
        LigneCommande ligneCommande = new LigneCommande(quantity , commande , product);
        commande.addLigneCommande(ligneCommande);
        commandRepositorie.save(commande);

    }

    @Transactional
    public void removeLigneCommande(LigneCommande ligneCommande)
    {
        Product product = ligneCommande.getProduct();
        product.setQuantity(ligneCommande.getQuantity() + product.getQuantity());
        productRepositorie.save(product);
        ligneCommandeRepositorie.delete(ligneCommande);
    }
}
