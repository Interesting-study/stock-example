package com.example.stock.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long produtId;

    private Long quantity;

    public Stock() {
    }

    public Stock(Long produtId, Long quantity) {
        this.produtId = produtId;
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void decrease(Long quantity){
        if (this.quantity - quantity < 0){
            throw new RuntimeException("foo");
        }

        this.quantity = this.quantity - quantity;
    }
}
