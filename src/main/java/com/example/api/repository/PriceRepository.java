package com.example.api.repository;

import com.example.api.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query("SELECT p FROM Price p WHERE p.startDate <= :date AND p.endDate >= :date AND p.productId = :productId AND p.brand.id = :brandId")
    List<Price> findAppliedPrice(@Param("date") LocalDateTime date,
                                 @Param("productId") Long productId,
                                 @Param("brandId") Long brandId);
}
