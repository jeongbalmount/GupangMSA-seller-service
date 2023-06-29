package GupangMSA.sellerservice.infrastructure;

import GupangMSA.sellerservice.domain.inventory.SellerInventory;

import java.util.List;

public interface SellerInventoryConnector {

    List<SellerInventory> findBySellerId(Long sellerId);

    SellerInventory update(SellerInventory sellerInventory);

}
