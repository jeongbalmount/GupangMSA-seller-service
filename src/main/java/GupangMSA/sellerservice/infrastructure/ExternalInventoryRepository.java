package GupangMSA.sellerservice.infrastructure;

import GupangMSA.sellerservice.domain.enums.ReturnStatus;
import GupangMSA.sellerservice.domain.product.SellerInventory;

import java.util.List;

public interface ExternalInventoryRepository {

    // 확인 수정
    List<SellerInventory> findById(Long productId);

    ReturnStatus update(SellerInventory sellerInventory);


}
