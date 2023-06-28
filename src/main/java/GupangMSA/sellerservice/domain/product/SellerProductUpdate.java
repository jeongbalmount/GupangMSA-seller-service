package GupangMSA.sellerservice.domain.product;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SellerProductUpdate {
    private final Long productId;
    private final String name;
    private final int price;
    private final String description;

    @Builder
    public SellerProductUpdate(Long id, String name, int price, String description) {
        this.productId = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
