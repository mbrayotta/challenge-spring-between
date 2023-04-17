package com.example.api.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PriceDTO {

    private Long productId;
    private Long brandId;
    private BigDecimal fee;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal finalAmount;


}

//identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.