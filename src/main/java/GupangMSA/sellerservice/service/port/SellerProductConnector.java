package GupangMSA.sellerservice.service.port;

import GupangMSA.sellerservice.domain.product.SellerProductResponse;
import GupangMSA.sellerservice.domain.product.SellerProductRequest;
import GupangMSA.sellerservice.domain.product.SellerProductUpdate;

import java.util.List;
import java.util.Optional;

public interface SellerProductConnector {
    // 등록
    SellerProductResponse save(SellerProductRequest request);

    Optional<SellerProductResponse> findById(Long id);

    // 조회
    List<SellerProductResponse> findBySellerId(Long sellerId);

    // 수정
    SellerProductResponse update(SellerProductUpdate sellerProductUpdate);

    // 삭제
    void delete(Long productId);

}
