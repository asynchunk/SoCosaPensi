package asynchunk.github.io;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class SoCosaPensi {
    private static JFrame frame;
    private static JTextField textField;
    private static int userNumber;

    public static void main(String[] args) {
        showInputWindow();
    }

    private static void showInputWindow() {
        frame = new JFrame("Coglione metti da 1 a 10 nella casella ");
        JLabel label = new JLabel("<html><b><font color='green'>coglione scrive un numero da 1 a 10</font></b></html>", SwingConstants.CENTER);
        textField = new JTextField(20);
        JButton button = new JButton("Manda sta roba");

        ActionListener actionListener = e -> {
            String text = textField.getText();
            int number = Integer.parseInt(text);
            if (number >= 1 && number <= 10) {
                userNumber = number;
                frame.dispose();
                showMessageWindow(0);
            } else {
                JOptionPane.showMessageDialog(frame, "Ti avevo detto di mettere un numero da 1 e 10 non sono Einstein");
            }
        };
        button.addActionListener(actionListener);
        textField.addActionListener(actionListener);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        frame.add(panel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private static void showMessageWindow(int messageIndex) {
        String[] messages = {"Sto cercando di vedere attraverso la tua mente", "Hai virus nel tuo pc devi buttarlo nel cesso", "Ho trovato nelle tue cartelle il sito PornHub",  "So cosa hai pensato: " + userNumber};

        if (messageIndex < messages.length - 1) {
            JFrame messageFrame = new JFrame("Aspetta coglione");
            JLabel messageLabel = new JLabel(messages[messageIndex], SwingConstants.CENTER);

            JPanel panel = new JPanel(new GridBagLayout());
            panel.add(messageLabel);

            messageFrame.add(panel);
            messageFrame.setSize(300, 250);
            messageFrame.setResizable(false);
            messageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            messageFrame.setLocationRelativeTo(null);
            messageFrame.setVisible(true);

            Timer timer = new Timer(1650, e -> {
                messageFrame.dispose();
                showMessageWindow(messageIndex + 1);
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            final JDialog dialog = new JDialog(frame, "Sto Caricando le palle aspetta...", true);
            dialog.setLayout(new FlowLayout());

            JButton backButton = new JButton("Torna su pornhub");
            backButton.addActionListener(e -> {
                dialog.dispose();
                showInputWindow();
            });

            JButton githubButton = new JButton("Metti una stella a sta merda sul mio profilo");
            githubButton.addActionListener(e -> {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/asynchunk/SoCosaPensi"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            });

            dialog.add(new JLabel(messages[messageIndex]));
            dialog.add(backButton);
            dialog.add(githubButton);

            dialog.setSize(300,150);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }
    }
}
