package com.gestao.api.history.models.entity;

import com.gestao.api.history.models.dto.HistoryDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZonedDateTime;

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

    @Column
    private LocalDate insertionDate;

    public ProductHistory(HistoryDTO dto){
        this.amount = dto.amount();
        this.productName = dto.productName();
        this.productId = dto.productId();
        this.insertionDate = LocalDate.now();
        this.incomes = 0;
        this.outcomes = 0;
    }
}
