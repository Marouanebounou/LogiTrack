package com.example.LogiTrack.Repositories;

import com.example.LogiTrack.Models.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeRepositorie extends JpaRepository<LigneCommande , Integer> {
}
