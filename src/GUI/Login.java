package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import static GUI.Menu.*;

public class Login extends JFrame {
    private CardLayout cardlayout;
    private JPanel mainp;
    private LoginListener loginListener;

    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/loginschema";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "dan1234";
    public interface LoginListener {
        void onLoginSuccess(String username);
    }

    public Login(LoginListener loginListener) {
        this.loginListener = loginListener;

        setTitle("Login/Register Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        cardlayout = new CardLayout();
        mainp = new JPanel(cardlayout);
        mainp.add(new menup(), "Menu");
        mainp.add(new loginp(), "Login");
        mainp.add(new registerp(), "Register");
        add(mainp);
        cardlayout.show(mainp, "Menu");
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    //meniul
    private class menup extends JPanel {
        public menup() {
            setLayout(new GridLayout(3, 1, 10, 10));

            JLabel welcomeLabel = new JLabel("Choose: ", SwingConstants.CENTER);
            add(welcomeLabel);

            JButton loginButton = new JButton("Login");
            loginButton.addActionListener(e -> cardlayout.show(mainp, "Login"));
            add(loginButton);

            JButton registerButton = new JButton("Register");
            registerButton.addActionListener(e -> cardlayout.show(mainp, "Register"));
            add(registerButton);
        }
    }

    //meniul de login
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

                    if (loginListener != null) {
                        loginListener.onLoginSuccess(username);
                    }
                    dispose();
                } else {
                    statusLabel.setText("Invalid username or password.");
                }
            }
        }
    }

    //meniul de register
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
                    statusLabel.setText("Username already exists or error!.");
                }
            }
        }
    }


    //verificare
    private boolean checkCredentials(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection connection = connect(); PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet resultSet = stmt.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean registerUser(String username, String password) {
        if (isUsernameTaken(username)) {
            return false;
        }
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error! during registration.");
        }
        return false;
    }

    private boolean isUsernameTaken(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error! checking username.");
        }
        return false;
    }
}
