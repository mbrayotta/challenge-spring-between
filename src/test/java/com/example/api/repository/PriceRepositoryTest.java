package com.example.api.repository;

import com.example.api.builder.PriceBuilder;
import com.example.api.domain.Price;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class PriceRepositoryTest {

    @Autowired
    private PriceRepository priceRepository;

    @Test
    public void testFindAppliedPriceOk() throws Exception{
        //given
        Price expectedPrice = PriceBuilder.getPrice();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse("2020-06-14T01:00:00", formatter);

        //when
        List<Price> prices = priceRepository.findAppliedPrice(date, 35455L, 1L);
        Price price = prices.get(0);

        //then
        assertNotNull(prices);
        assertEquals(expectedPrice.getProductId(), price.getProductId());
        assertEquals(expectedPrice.getBrand(), price.getBrand());
        assertEquals(expectedPrice.getStartDate(), price.getStartDate());
        assertEquals(expectedPrice.getEndDate(), price.getEndDate());
        assertEquals(expectedPrice.getFee(), price.getFee());
        assertEquals(expectedPrice.getPriority(), price.getPriority());
        assertEquals(expectedPrice.getAmount(), price.getAmount());
        assertEquals(expectedPrice.getCurr(), price.getCurr());
    }


}
