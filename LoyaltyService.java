package service;

import model.User;

public class LoyaltyService {

    public static double redeem(User user) {
        if (user.getLoyaltyPoint() >= 100) {
            user.usePoint(100);
            return 10000;
        }
        throw new RuntimeException("Poin tidak cukup");
    }
}
