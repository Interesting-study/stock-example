package com.example.stock.domain;

import javax.persistence.*;

@Entity
public class Stock {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private Long quantity;

    @Version
    private Long version;

    public Stock() {
    }

    public Stock(Long produtId, Long quantity) {
        this.productId = produtId;
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
