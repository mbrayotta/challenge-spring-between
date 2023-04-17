package com.example.api.mapper;

import com.example.api.builder.PriceBuilder;
import com.example.api.domain.Price;
import com.example.api.dto.PriceDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PriceMapperTest {
    @Test
    public void testMapPriceDTO() {
        //given
        Price price = PriceBuilder.getPrice();
        BigDecimal expectedFee = new BigDecimal("2.00").setScale(2);
        BigDecimal expectedAmount = new BigDecimal("35.50").setScale(2);

        //when
        PriceDTO priceDTO = PriceMapper.mapPriceDTO(price);

        //then
        assertNotNull(priceDTO);
        assertEquals(35455, priceDTO.getProductId());
        assertEquals(1, priceDTO.getBrandId());
        assertEquals(expectedFee, priceDTO.getFee());
        assertEquals(price.getStartDate(), priceDTO.getStartDate());
        assertEquals(price.getEndDate(), priceDTO.getEndDate());
        assertEquals(expectedAmount, priceDTO.getFinalAmount());


    }
}
