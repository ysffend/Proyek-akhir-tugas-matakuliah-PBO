package ui;

import javax.swing.*;
import model.User;
import service.LoyaltyService;

public class LoyaltyFrame extends JFrame {

    public LoyaltyFrame(User user) {
        setTitle("Loyalty");
        setSize(300, 300);

        JTextArea area = new JTextArea(10, 20);
        area.setEditable(false);

        area.append("Total Poin: " + user.getLoyaltyPoint() + "\n\n");
        user.getHistories().forEach(h -> area.append(h + "\n"));

        JButton redeem = new JButton("Tukar 100 Poin");

        redeem.addActionListener(e -> {
            try {
                double diskon = LoyaltyService.redeem(user);
                JOptionPane.showMessageDialog(this,
                        "Diskon Rp " + diskon);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        add(new JScrollPane(area), "Center");
        add(redeem, "South");
        setVisible(true);
    }
}
