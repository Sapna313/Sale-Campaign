package com.example.Sales.Campaign.repository;

import com.example.Sales.Campaign.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product , String> {

}
