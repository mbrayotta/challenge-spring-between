package com.example.api.builder;

import com.example.api.dto.PriceDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PriceDTOBuilder {
    private final PriceDTO price;

    public PriceDTOBuilder() {
        price = new PriceDTO();
    }

    public PriceDTO build() {
        return price;
    }

    public PriceDTOBuilder withProductId(long productId) {
        price.setProductId(productId);
        return this;
    }

    public PriceDTOBuilder withBrandId(long brandId) {
        price.setBrandId(brandId);
        return this;
    }

    public PriceDTOBuilder withFee(BigDecimal fee) {
        price.setFee(fee);
        return this;
    }

    public PriceDTOBuilder withStartDate(LocalDateTime startDate) {
        price.setStartDate(startDate);
        return this;
    }

    public PriceDTOBuilder withEndDate(LocalDateTime endDate) {
        price.setEndDate(endDate);
        return this;
    }

    public PriceDTOBuilder withFinalAmount(BigDecimal finalAmount) {
        price.setFinalAmount(finalAmount);
        return this;
    }

    public static PriceDTO getPriceDTOPriorityZero() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime startDateTime = LocalDateTime.parse("2020-06-14T00:00:00", formatter);
        LocalDateTime endDateTime = LocalDateTime.parse("2020-12-31T23:59:59", formatter);

        return new PriceDTOBuilder()
                .withProductId(35455)
                .withBrandId(1)
                .withFee(new BigDecimal("2.00").setScale(2))
                .withStartDate(startDateTime)
                .withEndDate(endDateTime)
                .withFinalAmount(new BigDecimal("35.50").setScale(2))
                .build();
    }

    public static PriceDTO getPriceDTOPriorityOne() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime startDateTime = LocalDateTime.parse("2020-06-14T15:00:00", formatter);
        LocalDateTime endDateTime = LocalDateTime.parse("2020-06-14T18:30:00", formatter);

        return new PriceDTOBuilder()
                .withProductId(35455)
                .withBrandId(1)
                .withFee(new BigDecimal("3.00").setScale(2))
                .withStartDate(startDateTime)
                .withEndDate(endDateTime)
                .withFinalAmount(new BigDecimal("25.45").setScale(2))
                .build();
    }
}
