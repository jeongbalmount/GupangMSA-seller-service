package GupangMSA.sellerservice.service;

import GupangMSA.sellerservice.domain.product.SellerProductResponse;
import GupangMSA.sellerservice.domain.product.SellerProductRequest;
import GupangMSA.sellerservice.domain.product.SellerProductUpdate;
import GupangMSA.sellerservice.exception.product.NoProductException;
import GupangMSA.sellerservice.infrastructure.SellerProductConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExternalProductService {

    private final SellerProductConnector connector;

    // 등록
    SellerProductResponse create(SellerProductRequest request) {
        return connector.save(request);
    }

    SellerProductResponse findById(Long id) {
        return connector.findById(id).orElseThrow(() -> new NoProductException("no found product"));
    }

    // 조회
    List<SellerProductResponse> findBySellerId(Long id) {
        return connector.findBySellerId(id);
    }

    // 수정
    SellerProductResponse update(Long id, SellerProductUpdate update) {
        return connector.update(id, update);
    }

    // 삭제
    void delete(Long id) {
        connector.delete(id);
    }

}
