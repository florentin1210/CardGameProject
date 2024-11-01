package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static GUI.Login.*;



public class Menu implements LoginListener {
    private JTextField usernameField;
    private RoundedButton loginButton;
    private JTextField usernameField2;
    private RoundedButton loginButton2;
    public int Player; // 1 pentru player1 , 2 pentru player2

    public Menu() {
        JFrame main = new JFrame("Hearthsnot");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(1920, 1080);

        BackgroundPanel menuPanel = new BackgroundPanel("src/GUI/background.jpg");
        menuPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);

        ImageIcon logoImageIcon = new ImageIcon("src/GUI/logo.png");
        JLabel logoLabel = new JLabel(logoImageIcon);
        RoundedButton playButton = new RoundedButton("Play");
        RoundedButton bdButton = new RoundedButton("Leaderboard");
        RoundedButton exitButton = new RoundedButton("Exit");

        Dimension buttonSize = new Dimension(400, 80);
        playButton.setPreferredSize(buttonSize);
        bdButton.setPreferredSize(buttonSize);
        exitButton.setPreferredSize(buttonSize);

        gbc.gridy = 0;
        menuPanel.add(logoLabel, gbc);

        gbc.gridy = 1;
        menuPanel.add(playButton, gbc);

        gbc.gridy = 2;
        menuPanel.add(bdButton, gbc);

        gbc.gridy = 3;
        menuPanel.add(exitButton, gbc);

        usernameField = new JTextField();
        usernameField.setBounds(30, 30, 150, 25);
        usernameField.setEditable(false);
        main.add(usernameField);

        loginButton = new RoundedButton("Login");
        loginButton.setBounds(190, 30, 80, 25);
        main.add(loginButton);

        usernameField2 = new JTextField();
        usernameField2.setBounds(30, 60, 150, 25);
        usernameField2.setEditable(false);
        main.add(usernameField2);

        loginButton2 = new RoundedButton("Login");
        loginButton2.setBounds(190, 60, 80, 25);
        main.add(loginButton2);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player = 1;
                openLoginGUI();
            }
        });

        loginButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player = 2;
                openLoginGUI();
            }
        });

        bdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LeaderboardGUI leaderboard = new LeaderboardGUI();
                leaderboard.setVisible(true);

            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        main.add(menuPanel);
        main.setVisible(true);

    }

    private void openLoginGUI() {
        Login login = new Login(this);
        login.setVisible(true);
    }

    @Override
    public void onLoginSuccess(String username) {
        if (Player == 1) {
            usernameField.setText(username);
        } else if (Player == 2) {
            usernameField2.setText(username);
        }
    }
}




