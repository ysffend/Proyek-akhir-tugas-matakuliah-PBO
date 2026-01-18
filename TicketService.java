package service;

import model.*;
import java.time.LocalTime;

public class TicketService {

    private static final double BASE_PRICE = 50000;

    public static double orderTicket(User user, int qty) {
        Subscription sub = user.getSubscription();
        double total = BASE_PRICE * qty;

        // STEP 4: Penalti jika tidak aktif
        if (sub == null || !sub.isActive()) {
            return total * 1.2; // penalti 20%
        }

        // Batas tiket
        if (qty > sub.getType().getMaxTicket()) {
            throw new RuntimeException("Melebihi batas tiket subscription!");
        }

        // Diskon subscription
        total -= total * sub.getType().getDiscount();

        // STEP 5: Promo jam 12–14
        int hour = LocalTime.now().getHour();
        if (hour >= 12 && hour <= 14) {
            total *= 0.9;
        }

        user.addPoint(qty * 10);
        return total;
    }

    // STEP 3: Refund tiket
    public static boolean refund(User user) {
        return user.getSubscription().getType() != SubscriptionType.REGULAR;
    }
}
