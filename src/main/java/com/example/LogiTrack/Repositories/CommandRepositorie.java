package com.example.LogiTrack.Repositories;

import com.example.LogiTrack.Models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandRepositorie extends JpaRepository<Commande , Integer> {

    @Query("select c from Commande c where c.client.id = :id")
    public List<Commande> findAllByClientId(@Param("id") int id);
}
