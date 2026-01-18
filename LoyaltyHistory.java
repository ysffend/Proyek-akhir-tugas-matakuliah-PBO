package model;

import java.time.LocalDateTime;

public class LoyaltyHistory {
    private String type;
    private int point;
    private LocalDateTime time = LocalDateTime.now();

    public LoyaltyHistory(String type, int point) {
        this.type = type;
        this.point = point;
    }

    @Override
    public String toString() {
        return time + " | " + type + " " + point;
    }
}
