package GupangMSA.sellerservice.service;

import GupangMSA.sellerservice.domain.inventory.SellerInventory;
import GupangMSA.sellerservice.domain.product.SellerProductRequest;
import GupangMSA.sellerservice.infrastructure.SellerInventoryConnector;
import GupangMSA.sellerservice.infrastructure.SellerProductConnector;
import GupangMSA.sellerservice.mock.FakeSellerInventoryConnector;
import GupangMSA.sellerservice.mock.FakeSellerProductConnector;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ExternalInventoryServiceTest {

    private  ExternalInventoryService externalInventoryService;

    @BeforeEach
    void init() {
        SellerProductRequest request1 = SellerProductRequest.builder()
                .sellerId(1L)
                .name("orange")
                .price(10000)
                .count(10)
                .category("fruit")
                .description("good quality")
                .build();
        SellerProductRequest request2 = SellerProductRequest.builder()
                .sellerId(1L)
                .name("laptop")
                .price(200000)
                .count(20)
                .category("tech")
                .description("good tech")
                .build();
        SellerProductRequest request3 = SellerProductRequest.builder()
                .sellerId(2L)
                .name("phone")
                .price(90000)
                .count(30)
                .category("tech")
                .description("good phone")
                .build();
        SellerProductConnector productConnector = new FakeSellerProductConnector();
        productConnector.save(request1);
        productConnector.save(request2);
        productConnector.save(request3);

        SellerInventoryConnector connector = new FakeSellerInventoryConnector(productConnector);
        this.externalInventoryService = new ExternalInventoryService(connector);
    }

    @Test
    void findBySellerId로_seller가_판매중인_상품의_재고를_알수있다() {
        // given

        // when
        List<SellerInventory> sellerInventories = externalInventoryService.findBySellerId(1L);

        // then
        assertThat(sellerInventories.size()).isEqualTo(2);
        assertThat(sellerInventories.get(0).getCount()).isEqualTo(10);
        assertThat(sellerInventories.get(1).getCount()).isEqualTo(20);
    }

    @Test
    void update함수로_인벤토리_값을_수정할_수_있다() {
        SellerInventory sellerInventory = SellerInventory.builder()
                .productId(1L)
                .count(999)
                .build();

        SellerInventory newSellerInventory = externalInventoryService.update(sellerInventory);

        assertThat(newSellerInventory.getCount()).isEqualTo(999);
    }

}
