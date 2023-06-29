package GupangMSA.sellerservice.domain.inventory;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SellerInventory {

    private final Long productId;
    private final int count;

    @Builder
    public SellerInventory(Long productId, int count) {
        this.productId = productId;
        this.count = count;
    }
}
