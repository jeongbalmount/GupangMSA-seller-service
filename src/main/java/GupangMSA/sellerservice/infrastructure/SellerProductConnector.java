package GupangMSA.sellerservice.infrastructure;

import GupangMSA.sellerservice.domain.product.SellerProduct;
import GupangMSA.sellerservice.domain.product.SellerProductUpdate;

import java.util.List;

public interface SellerProductConnector {

    // 등록
    void save(SellerProduct request);

    // 조회
    List<SellerProduct> findBySellerId(Long sellerId);

    // 수정
    SellerProduct update(SellerProductUpdate sellerProductUpdate);

    // 삭제
    void delete(Long productId);

}
