package com.example.Sales.Campaign.controller;
import com.example.Sales.Campaign.DTO.CampaignInfoDTO;
import com.example.Sales.Campaign.DTO.PageInfoDTO;
import com.example.Sales.Campaign.DTO.SaleCampaignRequestDTO;
import com.example.Sales.Campaign.services.CampaignService;
import com.example.Sales.Campaign.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CampaignService campaignService;



    @PostMapping("products/add")
    public String saveProductData(){
        return productService.addProduct();
    }

    @PostMapping("campaigns")
    public ResponseEntity<String> startCampaigns(@RequestBody SaleCampaignRequestDTO saleCampaignRequestDTO){
            campaignService.createCampaign(saleCampaignRequestDTO);
            return ResponseEntity.ok("Campaign created successfully");
    }


    @GetMapping("product/{page}/{pagesize}")
    public ResponseEntity<PageInfoDTO> getProductData(@PathVariable int page, @PathVariable int pagesize){
        Pageable pageable = PageRequest.of(page, pagesize);
        PageInfoDTO response = productService.getProducts(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("campaignInfo")
    public ResponseEntity<CampaignInfoDTO> getCampaignInfo(){
        CampaignInfoDTO response = campaignService.getAllCampaignsByStatus();
        return ResponseEntity.ok(response);
    }


}
