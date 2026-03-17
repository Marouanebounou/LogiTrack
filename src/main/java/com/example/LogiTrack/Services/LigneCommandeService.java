package com.example.LogiTrack.Services;

import com.example.LogiTrack.Models.Commande;
import com.example.LogiTrack.Models.LigneCommande;
import com.example.LogiTrack.Models.Product;
import com.example.LogiTrack.Repositories.CommandRepositorie;
import com.example.LogiTrack.Repositories.LigneCommandeRepositorie;
import com.example.LogiTrack.Repositories.ProductRepositorie;
import org.springframework.stereotype.Service;

@Service
public class LigneCommandeService {
    private final LigneCommandeRepositorie ligneCommandeRepositorie;
    private final ProductRepositorie productRepositorie;
    private final CommandRepositorie commandRepositorie;

    public LigneCommandeService(LigneCommandeRepositorie ligneCommandeRepositorie , ProductRepositorie productRepositorie , CommandRepositorie commandRepositorie)
    {
        this.ligneCommandeRepositorie = ligneCommandeRepositorie;
        this.productRepositorie = productRepositorie;
        this.commandRepositorie = commandRepositorie;
    }

    public void addLigneCommande(int productId , int ligneCommandeId , int commandeId)
    {
        Product product = productRepositorie.findById(productId).orElseThrow(IllegalArgumentException::new);
        LigneCommande ligneCommande = ligneCommandeRepositorie.findById(ligneCommandeId).orElseThrow(IllegalArgumentException::new);
        Commande commande = commandRepositorie.findById(commandeId).orElseThrow(IllegalArgumentException::new);
        ligneCommande.setProduct(product);
        ligneCommande.setCommande(commande);
        ligneCommandeRepositorie.save(ligneCommande);
    }


}
