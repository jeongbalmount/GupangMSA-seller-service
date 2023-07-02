package GupangMSA.sellerservice.service.port;

import GupangMSA.sellerservice.domain.Seller;

import java.util.Optional;

public interface SellerRepository {

    Seller save(Seller seller);

    Optional<Seller> findById(Long id);



}
