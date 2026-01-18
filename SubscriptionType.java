package model;

public enum SubscriptionType {
    REGULAR(0.0, 2),
    STUDENT(0.2, 4),
    VIP(0.4, 6);

    private double discount;
    private int maxTicket;

    SubscriptionType(double discount, int maxTicket) {
        this.discount = discount;
        this.maxTicket = maxTicket;
    }

    public double getDiscount() {
        return discount;
    }

    public int getMaxTicket() {
        return maxTicket;
    }
}
