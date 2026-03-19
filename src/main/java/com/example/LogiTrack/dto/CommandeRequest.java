package com.example.LogiTrack.dto;

import java.time.LocalDateTime;
import java.util.List;

public record CommandeRequest(LocalDateTime dateCommande , String statutCommande , int clientId , List<LigneRequest> ligneRequests) {
}
