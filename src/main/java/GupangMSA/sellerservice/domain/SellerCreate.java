package GupangMSA.sellerservice.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SellerCreate {

    private final String companyName;
    private final String representative;

    private final String email;
    private final String password;

    private final String city;
    private final String street;

    private final String zipcode;

    private final String phoneNumber;

    @Builder
    public SellerCreate(String companyName, String representative, String email, String password,
                        String city, String street, String zipcode, String phoneNumber) {
        this.companyName = companyName;
        this.representative = representative;
        this.email = email;
        this.password = password;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
    }
}
