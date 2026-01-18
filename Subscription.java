package model;

import java.time.LocalDate;

public class Subscription {
    private SubscriptionType type;
    private LocalDate endDate;

    public Subscription(SubscriptionType type, int days) {
        this.type = type;
        this.endDate = LocalDate.now().plusDays(days);
    }

    public boolean isActive() {
        return LocalDate.now().isBefore(endDate);
    }

    public SubscriptionType getType() {
        return type;
    }

    public void setType(SubscriptionType type) {
        this.type = type;
    }
}
