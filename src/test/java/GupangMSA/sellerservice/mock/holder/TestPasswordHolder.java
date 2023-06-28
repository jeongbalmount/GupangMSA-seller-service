package GupangMSA.sellerservice.mock.holder;

import GupangMSA.sellerservice.service.holder.PasswordHolder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestPasswordHolder implements PasswordHolder {

    private final String password;

    @Override
    public String password(String password) {
        return this.password;
    }
}
