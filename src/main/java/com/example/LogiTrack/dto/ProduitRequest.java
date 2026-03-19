package com.example.LogiTrack.dto;

import java.math.BigDecimal;

public record ProduitRequest(String name,
        String category, BigDecimal price,
        int quantity) {
}
