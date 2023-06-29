package GupangMSA.sellerservice.domain.product;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SellerProductRequest {

    private final Long id;
    private final Long sellerId;
    private final String name;
    private final int price;
    private final int count;
    private final String category;
    private final String description;

    @Builder
    public SellerProductRequest(Long id, Long sellerId, String name, int price, int count,
                                String category, String description) {
        this.id = id;
        this.sellerId = sellerId;
        this.name = name;
        this.price = price;
        this.count = count;
        this.category = category;
        this.description = description;
    }
}
