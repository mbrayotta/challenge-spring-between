package com.example.api.service.interfaces;

import com.example.api.dto.PriceDTO;

import java.time.LocalDateTime;

public interface IPriceService {
    PriceDTO getAppliedPrice(LocalDateTime date, Long product_id, Long brand_id);
}
