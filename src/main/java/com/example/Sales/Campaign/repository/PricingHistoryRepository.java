package com.example.Sales.Campaign.repository;

import com.example.Sales.Campaign.model.PricingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingHistoryRepository extends JpaRepository<PricingHistory , Long> {
}
