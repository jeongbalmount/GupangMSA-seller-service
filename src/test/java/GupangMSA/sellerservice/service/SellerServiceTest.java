package GupangMSA.sellerservice.service;

import GupangMSA.sellerservice.domain.Seller;
import GupangMSA.sellerservice.domain.SellerCreate;
import GupangMSA.sellerservice.mock.FakeSellerRepository;
import GupangMSA.sellerservice.mock.holder.TestClockHolder;
import GupangMSA.sellerservice.mock.holder.TestPasswordHolder;
import GupangMSA.sellerservice.mock.holder.TestUuidHolder;
import GupangMSA.sellerservice.service.holder.ClockHolder;
import GupangMSA.sellerservice.service.holder.PasswordHolder;
import GupangMSA.sellerservice.service.holder.UuidHolder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SellerServiceTest {

    private SellerService sellerService;

    @BeforeEach
    void init() {
        FakeSellerRepository repository = new FakeSellerRepository();
        ClockHolder clockHolder = new TestClockHolder(122333444499L);
        UuidHolder uuidHolder = new TestUuidHolder("1234-qwer-asdf-zxcv");
        PasswordHolder passwordHolder = new TestPasswordHolder("drowssap");

        Seller seller = Seller.builder()
                .id(1L)
                .companyName("sumsung")
                .representative("kang")
                .email("ss1@sumsung.com")
                .password("drowssap")
                .city("city")
                .street("st")
                .zipcode("zip")
                .phoneNumber("031-111-2221")
                .build();
        Seller seller2 = Seller.builder()
                .id(2L)
                .companyName("sumsung")
                .representative("jang")
                .email("ss2@sumsung.com")
                .password("drowssap")
                .city("city")
                .street("st")
                .zipcode("zip")
                .phoneNumber("031-111-2222")
                .build();
        Seller seller3 = Seller.builder()
                .id(3L)
                .companyName("sumsung")
                .representative("oh")
                .email("ss3@sumsung.com")
                .password("drowssap")
                .city("city")
                .street("st")
                .zipcode("zip")
                .phoneNumber("031-111-2223")
                .build();

        repository.save(seller);
        repository.save(seller2);
        repository.save(seller3);

        this.sellerService = new SellerService(repository, clockHolder, uuidHolder, passwordHolder);
    }

    @Test
    void create로_새로운_회원_생성_가능하다() {
        // given
        SellerCreate sellerCreate = new SellerCreate("sumsung", "kim", "ss@sumsung.com",
                "password","city", "st", "zip", "031-111-222");

        // when
        Seller seller = sellerService.create(sellerCreate);

        // then
        assertThat(seller.getId()).isNotNull();
        assertThat(seller.getEmail()).isEqualTo("ss@sumsung.com");
        assertThat(seller.getPassword()).isEqualTo("drowssap");
        assertThat(seller.getJoined()).isEqualTo(122333444499L);
        assertThat(seller.getSellerUuid()).isEqualTo("1234-qwer-asdf-zxcv");
    }

    @Test
    void login_함수로_로그인할_수_있다() {
        // given

        // when
        sellerService.login(1L);

        // then
        Seller seller = sellerService.findById(1L);
        assertThat(seller.getLastLogin()).isEqualTo(122333444499L);

    }

}
