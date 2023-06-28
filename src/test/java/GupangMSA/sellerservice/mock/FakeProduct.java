package GupangMSA.sellerservice.mock;

import lombok.Builder;
import lombok.Getter;


@Getter
public class FakeProduct {

    private final Long id;
    private final Long sellerId;
    private final String name;
    private final int price;
    private final String category;
    private final String description;

    @Builder
    public FakeProduct(Long id, Long sellerId,
                       String name, int price, String category, String description) {
        this.id = id;
        this.sellerId = sellerId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    /*
    private final String name;
    private final int price;
    private final String category;
    private final String description;
     */
    public SellerProductResponse to() {
        return SellerProductResponse.builder()
                .name(name)
                .price(price)
                .category(category)
                .description(description)
                .build();
    }

}
