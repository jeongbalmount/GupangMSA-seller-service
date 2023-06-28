package GupangMSA.sellerservice.domain;

import GupangMSA.sellerservice.domain.enums.SellerStatus;
import GupangMSA.sellerservice.service.holder.ClockHolder;
import GupangMSA.sellerservice.service.holder.PasswordHolder;
import GupangMSA.sellerservice.service.holder.UuidHolder;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Seller {

    private final Long id;
    private final String companyName;
    private final String representative;

    private final String email;
    private final String password;
    private final String city;
    private final String street;

    private final String zipcode;

    private final String phoneNumber;

    private final SellerStatus status;
    private final String sellerUuid;

    private final Long lastLogin;

    private final Long joined;

    @Builder
    public Seller(Long id, String companyName, String representative,
                  String email, String password, String city, String street, String zipcode,
                  String phoneNumber, SellerStatus status, String sellerUuid,
                  Long lastLogin, Long joined) {
        this.id = id;
        this.companyName = companyName;
        this.representative = representative;
        this.email = email;
        this.password = password;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.sellerUuid = sellerUuid;
        this.lastLogin = lastLogin;
        this.joined = joined;
    }

    public static Seller fromSellerCreate(SellerCreate sellerCreate, ClockHolder clockHolder,
                                          UuidHolder uuidHolder, PasswordHolder passwordHolder) {
        return Seller.builder()
                .companyName(sellerCreate.getCompanyName())
                .representative(sellerCreate.getRepresentative())
                .email(sellerCreate.getEmail())
                .password(passwordHolder.password(sellerCreate.getPassword()))
                .city(sellerCreate.getCity())
                .street(sellerCreate.getStreet())
                .zipcode(sellerCreate.getZipcode())
                .phoneNumber(sellerCreate.getPhoneNumber())
                .status(SellerStatus.PENDING)
                .joined(clockHolder.millis())
                .sellerUuid(uuidHolder.random())
                .build();
    }

    public Seller login(ClockHolder clockHolder) {

        return Seller.builder()
                .id(id)
                .companyName(companyName)
                .representative(representative)
                .email(email)
                .password(password)
                .city(city)
                .street(street)
                .zipcode(zipcode)
                .phoneNumber(phoneNumber)
                .status(status)
                .joined(joined)
                .sellerUuid(sellerUuid)
                .lastLogin(clockHolder.millis())
                .build();
    }

}
