package com.example.LogiTrack.Services;

import com.example.LogiTrack.Models.Commande;
import com.example.LogiTrack.Models.LigneCommande;
import com.example.LogiTrack.Models.Product;
import com.example.LogiTrack.Repositories.LigneCommandeRepositorie;
import com.example.LogiTrack.Repositories.ProductRepositorie;
import org.springframework.stereotype.Service;

@Service
public class LigneCommandeService {
    private final LigneCommandeRepositorie ligneCommandeRepositorie;
    private final ProductRepositorie productRepositorie;

    public LigneCommandeService(LigneCommandeRepositorie ligneCommandeRepositorie , ProductRepositorie productRepositorie)
    {
        this.ligneCommandeRepositorie = ligneCommandeRepositorie;
        this.productRepositorie = productRepositorie;
    }

    public void addLigneCommande(Product product , LigneCommande ligneCommande , Commande commande)
    {
        ligneCommande.setProduct(product);
        ligneCommande.setCommande(commande);
        ligneCommandeRepositorie.save(ligneCommande);
    }


}
