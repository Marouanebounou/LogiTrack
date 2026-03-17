package com.example.LogiTrack.Repositories;

import com.example.LogiTrack.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepositorie extends JpaRepository<Client , Integer> {
}
