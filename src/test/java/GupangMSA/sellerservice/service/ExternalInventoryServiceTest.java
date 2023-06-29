package GupangMSA.sellerservice.service;

import GupangMSA.sellerservice.domain.inventory.SellerInventory;
import GupangMSA.sellerservice.infrastructure.SellerInventoryConnector;
import GupangMSA.sellerservice.mock.FakeSellerInventoryConnector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExternalInventoryServiceTest {

    private  ExternalInventoryService externalInventoryService;

    @BeforeEach
    void init() {

//        SellerInventoryConnector connector = new FakeSellerInventoryConnector();
//        this.externalInventoryService = new ExternalInventoryService(connector);

    }

    @Test
    void findByProductId로_product() {

    }

}
