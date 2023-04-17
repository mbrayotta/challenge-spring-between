package com.example.api.controller;

import com.example.api.builder.PriceDTOBuilder;
import com.example.api.dto.PriceDTO;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@Transactional
public class PriceControllerTest extends AbstractFunctionalTest {
    private static final String PRICE_ENDPOINT = "/api/v1/price";

    @Test
    public void testGetProductPriceWithPriorityZeroOk() throws Exception {
        //given
        PriceDTO priceDTO = PriceDTOBuilder.getPriceDTOPriorityZero();
        //when
        MvcResult mvcResult = mockMvc.perform(get(PRICE_ENDPOINT)
                        .param("date", "2020-06-14T14:30:00")
                        .param("product_id", "35455")
                        .param("brand_id", "1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        //then
        String expectedPrice = objectMapper.writeValueAsString(priceDTO);
        assertEquals(expectedPrice, mvcResult.getResponse().getContentAsString());

    }

    @Test
    public void testGetProductPriceWithPriorityOneOk() throws Exception {
        //given
        PriceDTO priceDTO = PriceDTOBuilder.getPriceDTOPriorityOne();
        //when
        MvcResult mvcResult = mockMvc.perform(get(PRICE_ENDPOINT)
                        .param("date", "2020-06-14T16:00:00")
                        .param("product_id", "35455")
                        .param("brand_id", "1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        //then
        String expectedPrice = objectMapper.writeValueAsString(priceDTO);
        assertEquals(expectedPrice, mvcResult.getResponse().getContentAsString());

    }
    @Test
    public void testGetProductPriceIsNotFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get(PRICE_ENDPOINT)
                        .param("date", "2020-06-14T16:00:00")
                        .param("product_id", "1111")
                        .param("brand_id", "1")
                )
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("No value present"));
    }

}
