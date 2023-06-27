package GupangMSA.sellerservice.service;

import GupangMSA.sellerservice.domain.Seller;
import GupangMSA.sellerservice.domain.SellerCreate;
import GupangMSA.sellerservice.infrastructure.SellerRepository;
import GupangMSA.sellerservice.service.holder.ClockHolder;
import GupangMSA.sellerservice.service.holder.UuidHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerRepository;
    private final ClockHolder clockHolder;
    private final UuidHolder uuidHolder;

    public Seller create(SellerCreate sellerCreate){
        Seller seller = Seller.fromSellerCreate(sellerCreate, clockHolder, uuidHolder);
        return sellerRepository.save(seller);
    }

    public void login(Long id) {
        Seller seller = sellerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("no seller found"));
        seller = seller.login(clockHolder);
        sellerRepository.save(seller);
    }



}
