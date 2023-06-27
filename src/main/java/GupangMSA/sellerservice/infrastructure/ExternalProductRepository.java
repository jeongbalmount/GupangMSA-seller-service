package GupangMSA.sellerservice.infrastructure;

import GupangMSA.sellerservice.domain.product.SellerProduct;
import GupangMSA.sellerservice.domain.product.SellerProductResponse;
import GupangMSA.sellerservice.domain.product.SellerProductUpdate;

import java.util.List;

public interface ExternalProductRepository {

    // 등록
    SellerProductResponse save(SellerProduct sellerProduct);

    // 조회
    List<SellerProduct> findById(Long id);

    // 수정
    SellerProduct update(SellerProductUpdate sellerProductUpdate);

    // 삭제
    SellerProductResponse delete(Long productId);

}
