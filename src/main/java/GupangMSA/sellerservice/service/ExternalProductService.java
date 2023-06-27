package GupangMSA.sellerservice.service;

import GupangMSA.sellerservice.domain.product.SellerProduct;
import GupangMSA.sellerservice.domain.product.SellerProductResponse;
import GupangMSA.sellerservice.domain.product.SellerProductUpdate;
import GupangMSA.sellerservice.infrastructure.ExternalProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExternalProductService {

    private final ExternalProductRepository repository;

    // 등록
    SellerProductResponse create(SellerProduct sellerProduct) {
        return repository.save(sellerProduct);
    }

    // 조회
    List<SellerProduct> findById(Long id) {
        return repository.findById(id);
    }

    // 수정
    SellerProduct update(SellerProductUpdate update) {
        return repository.update(update);
    }

    // 삭제
    SellerProductResponse delete(Long productId) {
        return repository.delete(productId);
    }



}
