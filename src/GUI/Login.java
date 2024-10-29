package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Login extends JFrame{
    private CardLayout cardlayout;
    private JPanel mainp;
    public Login() {
        setTitle("Login/Register Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        cardlayout = new CardLayout();
        mainp = new JPanel(cardlayout);
        mainp.add(new menup(),"Menu");
        mainp.add(new loginp(), "Login");
        mainp.add(new registerp(), "Register");

        add(mainp);
        cardlayout.show(mainp,"Menu");

    }

    private class menup extends JPanel {
        public menup() {
            setLayout(new GridLayout(3, 1, 10, 10));

            JLabel welcomeLabel = new JLabel("Welcome! Please choose an option:", SwingConstants.CENTER);
            add(welcomeLabel);

            JButton loginButton = new JButton("Login");
            loginButton.addActionListener(e -> cardlayout.show(mainp, "Login"));
            add(loginButton);

            JButton registerButton = new JButton("Register");
            registerButton.addActionListener(e -> cardlayout.show(mainp, "Register"));
            add(registerButton);
        }
    }
    private class loginp extends JPanel {
        private JTextField usernameField;
        private JPasswordField passwordField;
        private JLabel statusLabel;

        public loginp() {
            setLayout(new GridLayout(4, 2, 10, 10));
            add(new JLabel("Username:"));
            usernameField = new JTextField();
            add(usernameField);

            add(new JLabel("Password:"));
            passwordField = new JPasswordField();
            add(passwordField);

            JButton loginButton = new JButton("Login");
            loginButton.addActionListener(new LoginAction());
            add(loginButton);

            JButton backButton = new JButton("Back to Menu");
            backButton.addActionListener(e -> cardlayout.show(mainp, "Menu"));
            add(backButton);

            statusLabel = new JLabel("", SwingConstants.CENTER);
            add(statusLabel);
        }

        private class LoginAction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (checkCredentials(username, password)) {
                    statusLabel.setText("Login Successful!");
                } else {
                    statusLabel.setText("Invalid username or password.");
                }
            }
        }
    }

    private class registerp extends JPanel {
        private JTextField usernameField;
        private JPasswordField passwordField;
        private JLabel statusLabel;

        public registerp() {
            setLayout(new GridLayout(4, 2, 10, 10));
            add(new JLabel("New Username:"));
            usernameField = new JTextField();
            add(usernameField);

            add(new JLabel("New Password:"));
            passwordField = new JPasswordField();
            add(passwordField);

            JButton registerButton = new JButton("Register");
            registerButton.addActionListener(new RegisterAction());
            add(registerButton);

            JButton backButton = new JButton("Back to Menu");
            backButton.addActionListener(e -> cardlayout.show(mainp, "Menu"));
            add(backButton);

            statusLabel = new JLabel("", SwingConstants.CENTER);
            add(statusLabel);
        }

        private class RegisterAction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (registerUser(username, password)) {
                    statusLabel.setText("Registration successful!");
                } else {
                    statusLabel.setText("Username already exists.");
                }
            }
        }
    }
    private boolean checkCredentials(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("database.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String fileUsername = parts[0].trim();
                    String filePassword = parts[1].trim();
                    if (fileUsername.equals(username) && filePassword.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading the database file.");
        }
        return false;
    }

    private boolean registerUser(String username, String password) {
        if (isUsernameTaken(username)) {
            return false;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt", true))) {
            writer.write(username + ":" + password);
            writer.newLine();
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to the database file.");
        }
        return false;
    }

    private boolean isUsernameTaken(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader("database.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].trim().equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading the database file.");
        }
        return false;
    }
}

