package ui;

import javax.swing.*;
import model.User;
import service.SubscriptionService;
import model.SubscriptionType;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Registrasi User");
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextField name = new JTextField(10);
        JComboBox<SubscriptionType> typeBox =
                new JComboBox<>(SubscriptionType.values());
        JButton btn = new JButton("Masuk");

        btn.addActionListener(e -> {
            User user = new User(name.getText());
            SubscriptionService.register(user,
                    (SubscriptionType) typeBox.getSelectedItem());
            new MainMenuFrame(user);
            dispose();
        });

        JPanel p = new JPanel();
        p.add(new JLabel("Nama"));
        p.add(name);
        p.add(typeBox);
        p.add(btn);
        add(p);
        setVisible(true);
    }
}
