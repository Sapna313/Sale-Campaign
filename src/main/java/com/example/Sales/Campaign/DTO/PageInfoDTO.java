package com.example.Sales.Campaign.DTO;

import java.util.List;

public class PageInfoDTO {
    private List<ProductResponseDTO> products;
    private int page;
    private int pageSize;
    private int totalPages;

    public PageInfoDTO() {
    }

    public PageInfoDTO(List<ProductResponseDTO> products, int page, int pageSize, int totalPages) {
        this.products = products;
        this.page = page;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
    }

    public List<ProductResponseDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponseDTO> products) {
        this.products = products;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
