package GupangMSA.sellerservice.domain.product;

import lombok.Builder;

import java.util.List;

public class SellerProduct {

    private final String name;
    private final int price;
    private final List<String> urls;
    private final String category;
    private final String description;

    @Builder
    public SellerProduct(String name, int price, List<String> urls, String category, String description) {
        this.name = name;
        this.price = price;
        this.urls = urls;
        this.category = category;
        this.description = description;
    }
}
