package com.noti.ExternalData;

public class SimulatedTrafficService implements TrafficService {
    @Override
    public String getTrafficCondition() {
        // Симуляция получения данных (например, из API или файла)
        return "Heavy traffic (8 points)";
    }
}
