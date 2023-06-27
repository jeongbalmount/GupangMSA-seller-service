package GupangMSA.sellerservice.domain.product;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SellerInventory {

    private final Long productId;
    private final int count;
}
