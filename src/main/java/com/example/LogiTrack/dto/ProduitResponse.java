package com.example.LogiTrack.dto;

import java.math.BigDecimal;

public record ProduitResponse(int id , String name,
                              String category, BigDecimal price,
                              int quantity) {}
