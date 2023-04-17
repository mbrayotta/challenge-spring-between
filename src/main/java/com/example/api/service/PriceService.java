package com.example.api.service;

import com.example.api.domain.Price;
import com.example.api.dto.PriceDTO;
import com.example.api.mapper.PriceMapper;
import com.example.api.repository.PriceRepository;
import com.example.api.service.interfaces.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService implements IPriceService {
    @Autowired
    private PriceRepository priceRepository;

    @Override
    public PriceDTO getAppliedPrice(LocalDateTime date, Long product_id, Long brand_id) {
        List<Price> prices = priceRepository.findAppliedPrice(date, product_id, brand_id);
        Price price = getPriorityPrice(prices);
        return PriceMapper.mapPriceDTO(price);
    }

    private Price getPriorityPrice(List<Price> prices) {
        return prices.stream().max(Comparator.comparingInt(Price::getPriority)).get();
    }
}
