package com.example.Sales.Campaign.DTO;

public class ProductResponseDTO {
    private String productId;
    private String Title;
    private double mrp;
    private double currentPrice;
    private int inventoryCount;
    private Double discount;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(String productId, String title, double mrp, double currentPrice, int inventoryCount, Double discount) {
        this.productId = productId;
        Title = title;
        this.mrp = mrp;
        this.currentPrice = currentPrice;
        this.inventoryCount = inventoryCount;
        this.discount = discount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
