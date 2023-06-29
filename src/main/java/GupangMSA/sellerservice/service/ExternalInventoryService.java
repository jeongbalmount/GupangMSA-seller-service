package GupangMSA.sellerservice.service;

import GupangMSA.sellerservice.domain.inventory.SellerInventory;
import GupangMSA.sellerservice.infrastructure.SellerInventoryConnector;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ExternalInventoryService {

    private final SellerInventoryConnector connector;

    List<SellerInventory> findBySellerId(Long sellerId) {
        return connector.findBySellerId(sellerId);
    }

    SellerInventory update(SellerInventory sellerInventory) {
        return connector.update(sellerInventory);
    }

}
