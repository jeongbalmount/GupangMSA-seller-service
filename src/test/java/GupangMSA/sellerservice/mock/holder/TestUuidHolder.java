package GupangMSA.sellerservice.mock.holder;

import GupangMSA.sellerservice.service.holder.UuidHolder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestUuidHolder implements UuidHolder {

    private final String uuid;
    @Override
    public String random() {
        return uuid;
    }
}
