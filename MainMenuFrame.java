package ui;

import javax.swing.*;
import model.User;
import model.SubscriptionType;
import service.SubscriptionService;

public class MainMenuFrame extends JFrame {

    private User user;
    private JLabel infoLabel = new JLabel();

    public MainMenuFrame(User user) {
        this.user = user;

        setTitle("Main Menu");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton ticket = new JButton("Pesan Tiket");
        JButton loyalty = new JButton("Loyalty");
        JButton changeSub = new JButton("Upgrade / Downgrade");

        ticket.addActionListener(e -> new TicketFrame(user));
        loyalty.addActionListener(e -> new LoyaltyFrame(user));

        changeSub.addActionListener(e -> {
            SubscriptionType newType = (SubscriptionType)
                    JOptionPane.showInputDialog(
                            this,
                            "Pilih Subscription",
                            "Ubah Subscription",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            SubscriptionType.values(),
                            user.getSubscription().getType()
                    );

            if (newType != null) {
                SubscriptionService.changeType(user, newType);
                updateInfo();
                JOptionPane.showMessageDialog(this,
                        "Subscription berhasil diubah!");
            }
        });

        updateInfo();

        JPanel panel = new JPanel();
        panel.add(infoLabel);
        panel.add(ticket);
        panel.add(loyalty);
        panel.add(changeSub);

        add(panel);
        setVisible(true);
    }

    private void updateInfo() {
        infoLabel.setText(
                "<html>" +
                        "<b>User:</b> " + user.getUsername() +
                        "<br><b>Subscription:</b> " + user.getSubscription().getType() +
                        "<br><b>Status:</b> " +
                        (user.getSubscription().isActive() ? "AKTIF" : "KADALUARSA") +
                        "<br><b>Diskon:</b> " +
                        (int)(user.getSubscription().getType().getDiscount()*100) + "%" +
                        "<br><b>Max Tiket:</b> " +
                        user.getSubscription().getType().getMaxTicket() +
                        "</html>"
        );
    }
}
