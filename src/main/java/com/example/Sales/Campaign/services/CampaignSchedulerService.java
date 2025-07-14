package com.example.Sales.Campaign.services;

import com.example.Sales.Campaign.model.CampaignDiscount;
import com.example.Sales.Campaign.model.PricingHistory;
import com.example.Sales.Campaign.model.Product;
import com.example.Sales.Campaign.repository.CampaignDiscountRepository;
import com.example.Sales.Campaign.repository.PricingHistoryRepository;
import com.example.Sales.Campaign.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CampaignSchedulerService {
    @Autowired
    private CampaignDiscountRepository campaignDiscountRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PricingHistoryRepository pricingHistoryRepository;


    @Scheduled(cron = "0 * * * * *") // every 1 minute
    public void applyDiscount() {
        System.out.println("applyDiscount running at: " + LocalDateTime.now());
        LocalDate today = LocalDate.now();
        List<CampaignDiscount> discounts = campaignDiscountRepository.findBySaleCampaign_startDate(today);

        for (CampaignDiscount cd : discounts) {
            Product product = cd.getProduct();
            double discountedPrice = product.getMrp() * (1 - cd.getDiscount() / 100);
            if (product.getCurrentPrice() != discountedPrice) {
                double oldPrice = product.getCurrentPrice();
                product.setCurrentPrice(discountedPrice);
                productRepository.save(product);

                PricingHistory pricingHistory = new PricingHistory(product, oldPrice, discountedPrice, "Campaign started: " + cd.getSaleCampaign().getCampaignName(), LocalDate.now());
                pricingHistoryRepository.save(pricingHistory);

            }
        }
    }

    @Scheduled(cron = "0 * * * * *")
    public void revertDiscounts() {
        System.out.println("end running at: " + LocalDateTime.now());
        LocalDate today = LocalDate.now();
        List<CampaignDiscount> endedDiscounts = campaignDiscountRepository.findBySaleCampaign_EndDate(today);

        for (CampaignDiscount cd : endedDiscounts) {
            Product product = cd.getProduct();
            double mrp = product.getMrp();

            if (product.getCurrentPrice() != mrp) {
                double oldPrice = product.getCurrentPrice();
                product.setCurrentPrice(mrp);
                productRepository.save(product);

                PricingHistory history = new PricingHistory(product, oldPrice, mrp,
                        "Campaign Ended: " + cd.getSaleCampaign().getCampaignName(), today);
                pricingHistoryRepository.save(history);
            }
        }
    }
}
