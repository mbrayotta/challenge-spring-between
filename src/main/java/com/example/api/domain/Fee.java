package com.example.api.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "fees")
@Data
public class Fee {
    @Id
    private Long id;
    private BigDecimal amount;

}
