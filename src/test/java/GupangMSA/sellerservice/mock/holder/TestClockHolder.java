package GupangMSA.sellerservice.mock.holder;

import GupangMSA.sellerservice.service.holder.ClockHolder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestClockHolder implements ClockHolder {

    private final Long milles;
    @Override
    public Long millis() {
        return milles;
    }
}
