package com.example.Sales.Campaign.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pricing_history")
public class PricingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pricingId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private double oldPrice;
    private double currentPrice;
    private String title;
    private LocalDate changeDate;

    public PricingHistory() {
    }

    public PricingHistory(Product product, double oldPrice, double currentPrice, String title, LocalDate changeDate) {
        this.product = product;
        this.oldPrice = oldPrice;
        this.currentPrice = currentPrice;
        this.title = title;
        this.changeDate = changeDate;
    }

    public long getPricingId() {
        return pricingId;
    }

    public void setPricingId(long pricingId) {
        this.pricingId = pricingId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDate changeDate) {
        this.changeDate = changeDate;
    }
}
