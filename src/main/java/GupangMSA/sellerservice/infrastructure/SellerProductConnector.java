package GupangMSA.sellerservice.infrastructure;

import GupangMSA.sellerservice.domain.product.SellerProduct;
import GupangMSA.sellerservice.domain.product.SellerProductUpdate;

import java.util.List;
import java.util.Optional;

public interface SellerProductConnector {

    // 등록
    SellerProduct save(SellerProduct request);

    Optional<SellerProduct> findById(Long id);

    // 조회
    List<SellerProduct> findBySellerId(Long sellerId);

    // 수정
    SellerProduct update(Long id, SellerProductUpdate sellerProductUpdate);

    // 삭제
    void delete(Long productId);

}
