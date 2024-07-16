package com.gestao.api.history.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_history")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long productId;
    @Column(length = 120)
    private String productName;
    @Column
    private int amount;
    @Column
    private int incomes;
    @Column
    private int outcomes;


}
