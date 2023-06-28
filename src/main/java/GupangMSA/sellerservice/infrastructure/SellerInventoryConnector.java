package GupangMSA.sellerservice.infrastructure;

import GupangMSA.sellerservice.domain.enums.ReturnStatus;
import GupangMSA.sellerservice.domain.inventory.SellerInventory;

import java.util.List;

public interface SellerInventoryConnector {

    // 확인 수정
    List<SellerInventory> findById(Long productId);

    ReturnStatus update(SellerInventory sellerInventory);

}
