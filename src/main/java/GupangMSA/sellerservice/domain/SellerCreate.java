package GupangMSA.sellerservice.domain;

import lombok.Getter;

@Getter
public class SellerCreate {

    private final String companyName;
    private final String representative;

    private final String email;
    private final String city;
    private final String street;

    private final String zipcode;

    private final String phoneNumber;

    public SellerCreate(String companyName, String representative, String email,
                        String city, String street, String zipcode, String phoneNumber) {
        this.companyName = companyName;
        this.representative = representative;
        this.email = email;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
    }
}
