package com.example.Sales.Campaign.services;

import com.example.Sales.Campaign.DTO.PageInfoDTO;
import com.example.Sales.Campaign.DTO.ProductResponseDTO;
import com.example.Sales.Campaign.model.Product;
import com.example.Sales.Campaign.repository.CampaignDiscountRepository;
import com.example.Sales.Campaign.repository.ProductRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CampaignDiscountRepository campaignDiscountRepository;

    public String addProduct() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/products_data.json");
            List<Product> productList = mapper.readValue(inputStream, new TypeReference<>() {
            });
            productRepository.saveAll(productList);
            return "Data saved successfully";
        } catch (Exception e) {
            return "Error" + e.getMessage();
        }
    }


    public PageInfoDTO getProducts(Pageable pageable) {
        Page<Product> productPage = productRepository.findAll(pageable);
        LocalDate today = LocalDate.now();
        List<ProductResponseDTO> productDTOList = new ArrayList<>();


        for (Product product : productPage.getContent()) {
            Double discount = campaignDiscountRepository.findActiveDiscountByProductId(product.getProductId(), today).orElse(null);
//            System.out.println(discount);
            ProductResponseDTO dto = new ProductResponseDTO(
                    product.getProductId(),
                    product.getTitle(),
                    product.getMrp(),
                    product.getCurrentPrice(),
                    product.getInventoryCount(),
                    discount
            );
            productDTOList.add(dto);

        }
        return new PageInfoDTO(productDTOList, productPage.getNumber(), productPage.getSize(), productPage.getTotalPages());
    }
}
