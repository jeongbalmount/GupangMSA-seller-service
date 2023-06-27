package GupangMSA.sellerservice.domain.product;

import lombok.Builder;

public class SellerProductUpdate {

    private final Long id;

    private final String name;
    private final int price;
    private final String description;

    @Builder
    public SellerProductUpdate(Long id, String name, int price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
