package com.example.api.mapper;

import com.example.api.domain.Price;
import com.example.api.dto.PriceDTO;

public class PriceMapper {
    public static PriceDTO mapPriceDTO(Price price) {
        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setProductId(price.getProductId());
        priceDTO.setBrandId(price.getBrand().getId());
        priceDTO.setFee(price.getFee().getAmount());
        priceDTO.setStartDate(price.getStartDate());
        priceDTO.setEndDate(price.getEndDate());
        priceDTO.setFinalAmount(price.getAmount());

        return priceDTO;
    }
}
