package com.example.Sales.Campaign.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "campaign_discount")
public class CampaignDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long campaignDiscountId;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private SaleCampaign saleCampaign;
    private double discount;

    public CampaignDiscount() {
    }

    public CampaignDiscount(Product product, SaleCampaign saleCampaign, double discount) {
        this.product = product;
        this.saleCampaign = saleCampaign;
        this.discount = discount;
    }

    public long getCampaignId() {
        return campaignDiscountId;
    }

    public void setCampaignId(long campaignDiscountId) {
        this.campaignDiscountId = campaignDiscountId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SaleCampaign getSaleCampaign() {
        return saleCampaign;
    }

    public void setSaleCampaign(SaleCampaign saleCampaign) {
        this.saleCampaign = saleCampaign;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CampaignDiscount that = (CampaignDiscount) o;
        return campaignDiscountId == that.campaignDiscountId && Double.compare(discount, that.discount) == 0 && Objects.equals(product, that.product) && Objects.equals(saleCampaign, that.saleCampaign);
    }

    @Override
    public int hashCode() {
        return Objects.hash(campaignDiscountId, product, saleCampaign, discount);
    }
}
