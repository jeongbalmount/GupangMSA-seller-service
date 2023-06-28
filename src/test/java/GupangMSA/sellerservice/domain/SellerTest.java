package GupangMSA.sellerservice.domain;

import GupangMSA.sellerservice.mock.holder.TestClockHolder;
import GupangMSA.sellerservice.mock.holder.TestPasswordHolder;
import GupangMSA.sellerservice.mock.holder.TestUuidHolder;
import GupangMSA.sellerservice.service.holder.ClockHolder;
import GupangMSA.sellerservice.service.holder.PasswordHolder;
import GupangMSA.sellerservice.service.holder.UuidHolder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SellerTest {
    @Test
    void SellerCreate_객체로_Seller를_만들_수_있다() {

        // given
        SellerCreate sellerCreate = new SellerCreate("sumsung", "kim", "ss@sumsung.com",
                "password","city", "st", "zip", "031-111-222");
        ClockHolder clockHolder = new TestClockHolder(1223334444L);
        UuidHolder uuidHolder = new TestUuidHolder("1234-qwer-asdf-zxcv");
        PasswordHolder passwordHolder = new TestPasswordHolder("drowssap");

        // when
        Seller seller = Seller.fromSellerCreate(sellerCreate, clockHolder, uuidHolder, passwordHolder);

        // then
        assertThat(seller.getEmail()).isEqualTo("ss@sumsung.com");
        assertThat(seller.getJoined()).isEqualTo(1223334444L);
        assertThat(seller.getPassword()).isEqualTo("drowssap");
        assertThat(seller.getSellerUuid()).isEqualTo("1234-qwer-asdf-zxcv");
    }

    @Test
    void login_메서드를_이용해_로그인할_수_있다() {

        // given
        Seller seller = Seller.builder()
                .id(1L)
                .companyName("sumsung")
                .representative("kim")
                .email("ss@sumsung.com")
                .password("drowssap")
                .city("city")
                .street("st")
                .zipcode("zip")
                .phoneNumber("031-111-222")
                .lastLogin(1223334444L)
                .build();
        ClockHolder clockHolder = new TestClockHolder(2233444455555L);

        // when
        seller = seller.login(clockHolder);

        // then
        assertThat(seller.getLastLogin()).isEqualTo(2233444455555L);


    }


}
