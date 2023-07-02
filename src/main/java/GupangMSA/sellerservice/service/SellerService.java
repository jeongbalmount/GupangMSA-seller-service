package GupangMSA.sellerservice.service;

import GupangMSA.sellerservice.domain.Seller;
import GupangMSA.sellerservice.domain.SellerCreate;
import GupangMSA.sellerservice.exception.NoSellerException;
import GupangMSA.sellerservice.service.port.SellerRepository;
import GupangMSA.sellerservice.service.holder.ClockHolder;
import GupangMSA.sellerservice.service.holder.PasswordHolder;
import GupangMSA.sellerservice.service.holder.UuidHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerRepository;
    private final ClockHolder clockHolder;
    private final UuidHolder uuidHolder;
    private final PasswordHolder passwordHolder;

    public Seller create(SellerCreate sellerCreate){
        Seller seller = Seller.fromSellerCreate(sellerCreate, clockHolder, uuidHolder, passwordHolder);
        return sellerRepository.save(seller);
    }

    public void login(Long id) {
        Seller seller = sellerRepository.findById(id).orElseThrow(() ->
                new NoSellerException("no seller found"));
        seller = seller.login(clockHolder);

        sellerRepository.save(seller);
    }

    public Seller findById(Long id) {
        return sellerRepository.findById(id).orElseThrow(() ->
                new NoSellerException("no seller found"));
    }

}
