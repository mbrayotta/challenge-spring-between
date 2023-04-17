package com.example.api.controller;

import com.example.api.dto.PriceDTO;
import com.example.api.service.interfaces.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/price")
public class PriceController {
    @Autowired
    private IPriceService priceService;

    @GetMapping
    public ResponseEntity<PriceDTO> getProductPrice(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime date,
                                                    @RequestParam("product_id") Long product_id,
                                                    @RequestParam("brand_id") Long brand_id) {
        PriceDTO priceDTO = priceService.getAppliedPrice(date, product_id, brand_id);
        return new ResponseEntity<>(priceDTO, HttpStatus.OK);
    }

}
