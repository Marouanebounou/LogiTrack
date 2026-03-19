package com.example.LogiTrack.dto;

import java.time.LocalDateTime;
import java.util.List;

public record CommandeResponse(int id,LocalDateTime dateCommande,String statutCommande, String clientName,List<LigneResponse> lignes) {}
