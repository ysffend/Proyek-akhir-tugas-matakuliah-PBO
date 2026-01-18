package service;

import model.*;

public class SubscriptionService {

    public static void register(User user, SubscriptionType type) {
        user.setSubscription(new Subscription(type, 30));
    }

    public static void changeType(User user, SubscriptionType type) {
        user.getSubscription().setType(type);
    }
}
