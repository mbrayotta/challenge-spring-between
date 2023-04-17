package com.example.api.builder;

import com.example.api.domain.Brand;
import com.example.api.domain.Fee;
import com.example.api.domain.Price;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PriceBuilder {
    private final Price price;

    public PriceBuilder() {
        price = new Price();
    }

    public Price build() {
        return price;
    }

    public PriceBuilder withId(long id) {
        price.setId(id);
        return this;
    }

    public PriceBuilder withBrand() {
        Brand brand = new Brand();
        brand.setId(1L);
        brand.setName("ZARA");
        price.setBrand(brand);
        return this;
    }

    public PriceBuilder withStartDate(LocalDateTime startDate) {
        price.setStartDate(startDate);
        return this;
    }

    public PriceBuilder withEndDate(LocalDateTime endDate) {
        price.setEndDate(endDate);
        return this;
    }

    public PriceBuilder withFee(Fee fee) {
        price.setFee(fee);
        return this;
    }

    public PriceBuilder withProductId(long productId) {
        price.setProductId(productId);
        return this;
    }

    public PriceBuilder withPriority(Integer priority) {
        price.setPriority(priority);
        return this;
    }

    public PriceBuilder withAmount(BigDecimal amount) {
        price.setAmount(amount);
        return this;
    }

    public PriceBuilder withCurr(String curr) {
        price.setCurr(curr);
        return this;
    }

    public static Price getPrice() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime startDateTime = LocalDateTime.parse("2020-06-14T00:00:00", formatter);
        LocalDateTime endDateTime = LocalDateTime.parse("2020-12-31T23:59:59", formatter);

        Fee fee = new Fee();
        fee.setId(1L);
        fee.setAmount(new BigDecimal("2.00").setScale(2));

        return new PriceBuilder()
                .withId(1)
                .withBrand()
                .withFee(fee)
                .withStartDate(startDateTime)
                .withEndDate(endDateTime)
                .withProductId(35455)
                .withPriority(0)
                .withAmount(new BigDecimal("35.50").setScale(2))
                .withCurr("EUR")
                .build();
    }

}
