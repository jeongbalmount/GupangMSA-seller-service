package GupangMSA.sellerservice.service;

import GupangMSA.sellerservice.domain.product.SellerProduct;
import GupangMSA.sellerservice.domain.product.SellerProductUpdate;
import GupangMSA.sellerservice.infrastructure.SellerProductConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExternalProductService {

    private final SellerProductConnector connector;

    // 등록
    void create(SellerProduct request) {
        connector.save(request);
    }

    // 조회
    List<SellerProduct> findBySellerId(Long id) {
        return connector.findBySellerId(id);
    }

    // 수정
    SellerProduct update(SellerProductUpdate update) {
        return connector.update(update);
    }

    // 삭제
    void delete(Long productId) {
        connector.delete(productId);
    }

}
