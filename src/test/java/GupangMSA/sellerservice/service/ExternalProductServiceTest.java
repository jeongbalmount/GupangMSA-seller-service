package GupangMSA.sellerservice.service;

import GupangMSA.sellerservice.domain.product.SellerProductResponse;
import GupangMSA.sellerservice.domain.product.SellerProductRequest;
import GupangMSA.sellerservice.domain.product.SellerProductUpdate;
import GupangMSA.sellerservice.exception.product.NoProductException;
import GupangMSA.sellerservice.infrastructure.SellerProductConnector;
import GupangMSA.sellerservice.mock.FakeSellerProductConnector;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
public class ExternalProductServiceTest {

    private ExternalProductService externalProductService;

    @BeforeEach
    void init() {
        SellerProductConnector connector = new FakeSellerProductConnector();
        SellerProductRequest request1 = SellerProductRequest.builder()
                .id(1L)
                .sellerId(1L)
                .name("orange")
                .price(10000)
                .count(10)
                .category("fruit")
                .description("good quality")
                .build();
        SellerProductRequest request2 = SellerProductRequest.builder()
                .id(2L)
                .sellerId(1L)
                .name("laptop")
                .price(200000)
                .count(20)
                .category("tech")
                .description("good tech")
                .build();
        SellerProductRequest request3 = SellerProductRequest.builder()
                .id(3L)
                .sellerId(2L)
                .name("phone")
                .price(90000)
                .count(30)
                .category("tech")
                .description("good phone")
                .build();
        connector.save(request1);
        connector.save(request2);
        connector.save(request3);

        this.externalProductService = new ExternalProductService(connector);
    }

    @Test
    void create로_product를_만들_수_있다() {
        // given
        SellerProductRequest request = SellerProductRequest.builder()
                .sellerId(1L)
                .name("great apple")
                .price(1000)
                .count(100)
                .category("fruit")
                .description("good quality")
                .build();
        // when
        SellerProductResponse newSellerProduct = this.externalProductService.create(request);
        // then
        assertThat(newSellerProduct.getId()).isNotNull();
        assertThat(newSellerProduct.getName()).isEqualTo("great apple");
    }

    @Test
    void findById_메서드로_product_1개를_찾을_수_있다() {
        // given

        // when
        SellerProductResponse sellerProduct = this.externalProductService.findById(1L);

        // then
        assertThat(sellerProduct.getName()).isEqualTo("orange");
    }

    @Test
    void findbySellerId_메서드로_seller가_등록한_product들을_찾을_수_있다() {
        // given
        // when
        List<SellerProductResponse> products = this.externalProductService.findBySellerId(1L);

        // then
        for (SellerProductResponse product : products) {
            assertThat(product.getSellerId()).isEqualTo(1L);
        }
    }

    @Test
    void findByUpdate_메서드로_product를_수정할_수_있다() {
        // given
        SellerProductUpdate sellerProductUpdate = SellerProductUpdate.builder()
                .name("another name")
                .price(12345)
                .description("changed description")
                .build();

        // when
        SellerProductResponse updateProduct = this.externalProductService.update(3L, sellerProductUpdate);

        // then
        assertThat(updateProduct.getName()).isEqualTo("another name");
        assertThat(updateProduct.getPrice()).isEqualTo(12345);
        assertThat(updateProduct.getDescription()).isEqualTo("changed description");
    }

    @Test
    void delete로_product를_삭제할_수_있다() {
        // given

        // when
        this.externalProductService.delete(3L);

        // then
        assertThatThrownBy(() -> this.externalProductService.findById(3L))
                .isInstanceOf(NoProductException.class);
    }
}
