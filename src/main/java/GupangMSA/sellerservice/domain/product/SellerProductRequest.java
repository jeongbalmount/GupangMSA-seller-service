package GupangMSA.sellerservice.domain.product;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SellerProductRequest {

    private final Long sellerId;
    private final String name;
    private final int price;
    private final int count;
    private final String category;
    private final String description;

    @Builder
    public SellerProductRequest(Long sellerId, String name, int price, int count,
                                String category, String description) {
        this.sellerId = sellerId;
        this.name = name;
        this.price = price;
        this.count = count;
        this.category = category;
        this.description = description;
    }
}
