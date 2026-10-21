package com.noti.ExternalData;

public class FakeTrafficService implements TrafficService {
    @Override
    public String getTrafficCondition() {
        return "Test Traffic Status";
    }
}
