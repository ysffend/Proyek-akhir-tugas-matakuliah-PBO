package model;

import java.util.*;

public class User {
    private String name;
    private Subscription subscription;
    private int loyaltyPoint;
    private List<LoyaltyHistory> histories = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    // ✅ FIX ERROR UI
    public String getUsername() {
        return name;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public int getLoyaltyPoint() {
        return loyaltyPoint;
    }

    public void addPoint(int point) {
        loyaltyPoint += point;
        histories.add(new LoyaltyHistory("Tambah", point));
    }

    public void usePoint(int point) {
        loyaltyPoint -= point;
        histories.add(new LoyaltyHistory("Pakai", point));
    }

    public List<LoyaltyHistory> getHistories() {
        return histories;
    }
}
