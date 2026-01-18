package ui;

import javax.swing.*;
import model.User;
import service.TicketService;

public class TicketFrame extends JFrame {

    public TicketFrame(User user) {
        setTitle("Pesan Tiket");
        setSize(350, 250);

        JComboBox<String> film = new JComboBox<>(
                new String[]{"Avengers", "Interstellar", "Dune"});
        JComboBox<String> jam = new JComboBox<>(
                new String[]{"10:00", "13:00", "19:00"});
        JTextField qty = new JTextField(3);

        JLabel promo = new JLabel("Promo 12.00–14.00 (Diskon 10%)");

        JButton pesan = new JButton("Pesan");
        JButton refund = new JButton("Refund");

        pesan.addActionListener(e -> {
            try {
                double total = TicketService.orderTicket(
                        user, Integer.parseInt(qty.getText()));
                JOptionPane.showMessageDialog(this,
                        "Total Bayar: Rp " + total +
                                "\nPoin: " + user.getLoyaltyPoint());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        refund.addActionListener(e -> {
            if (TicketService.refund(user)) {
                JOptionPane.showMessageDialog(this,
                        "Refund berhasil!");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Refund tidak tersedia untuk REGULAR");
            }
        });

        JPanel p = new JPanel();
        p.add(film);
        p.add(jam);
        p.add(new JLabel("Jumlah"));
        p.add(qty);
        p.add(promo);
        p.add(pesan);
        p.add(refund);

        add(p);
        setVisible(true);
    }
}
