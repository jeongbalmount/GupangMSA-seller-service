package GupangMSA.sellerservice.domain.inventory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SellerInventory {

    private final Long productId;
    private final int count;
}
