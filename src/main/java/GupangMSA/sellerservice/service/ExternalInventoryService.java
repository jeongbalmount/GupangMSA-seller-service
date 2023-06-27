package GupangMSA.sellerservice.service;

import GupangMSA.sellerservice.domain.enums.ReturnStatus;
import GupangMSA.sellerservice.domain.product.SellerInventory;
import GupangMSA.sellerservice.infrastructure.ExternalInventoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ExternalInventoryService {

    private final ExternalInventoryRepository repository;

    List<SellerInventory> findById(Long productId) {
        return repository.findById(productId);
    }

    ReturnStatus update(SellerInventory sellerInventory) {
        return repository.update(sellerInventory);
    }

}
