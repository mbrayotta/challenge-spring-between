package com.example.api.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
@Data
public class Brand {
    @Id
    private Long id;
    private String name;
}
