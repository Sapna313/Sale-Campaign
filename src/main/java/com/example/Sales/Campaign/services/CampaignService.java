package com.example.Sales.Campaign.services;

import com.example.Sales.Campaign.DTO.CampaignDiscountDTO;
import com.example.Sales.Campaign.DTO.CampaignInfoDTO;
import com.example.Sales.Campaign.DTO.SaleCampaignRequestDTO;
import com.example.Sales.Campaign.model.CampaignDiscount;
import com.example.Sales.Campaign.model.PricingHistory;
import com.example.Sales.Campaign.model.Product;
import com.example.Sales.Campaign.model.SaleCampaign;
import com.example.Sales.Campaign.repository.CampaignDiscountRepository;
import com.example.Sales.Campaign.repository.PricingHistoryRepository;
import com.example.Sales.Campaign.repository.ProductRepository;
import com.example.Sales.Campaign.repository.SaleCampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CampaignService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    SaleCampaignRepository saleCampaignRepository;
    @Autowired
    CampaignDiscountRepository campaignDiscountRepository;
    @Autowired
    PricingHistoryRepository pricingHistoryRepository;


    public void createCampaign(SaleCampaignRequestDTO saleCampaignRequestDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate = LocalDate.parse(saleCampaignRequestDTO.getStartDate(), formatter);
        LocalDate endDate = LocalDate.parse(saleCampaignRequestDTO.getEndDate(), formatter);

        SaleCampaign saleCampaign = new SaleCampaign(saleCampaignRequestDTO.getCampaignName(), startDate, endDate);
        saleCampaignRepository.save(saleCampaign);

        for (CampaignDiscountDTO campaignDiscountDTO : saleCampaignRequestDTO.getListOfCampaign()) {
            Product product = productRepository.findById(campaignDiscountDTO.getProductId()).orElse(null);
            if (product == null) {
                throw new RuntimeException("Product Not Found");
            }
            CampaignDiscount campaignDiscount = new CampaignDiscount(product, saleCampaign, campaignDiscountDTO.getDiscount());
            campaignDiscountRepository.save(campaignDiscount);

        }
    }

    public CampaignInfoDTO getAllCampaignsByStatus() {
        LocalDate today = LocalDate.now();

        List<SaleCampaign> pastCampaign = saleCampaignRepository.findPastCampaigns(today);
        List<SaleCampaign> currentCampaign = saleCampaignRepository.findCurrentCampaigns(today);
        List<SaleCampaign> futureCampaign = saleCampaignRepository.findFutureCampaigns(today);

        return new CampaignInfoDTO(pastCampaign, currentCampaign, futureCampaign);
    }
}
