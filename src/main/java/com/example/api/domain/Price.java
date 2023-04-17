package com.example.api.domain;


import lombok.Data;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@Data
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "fee_id")
    private Fee fee;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "curr")
    private String curr;
}
