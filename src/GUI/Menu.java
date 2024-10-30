package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Menu {
    public Menu(){
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
        RoundedButton bdButton = new RoundedButton("bd");
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

        bdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.setVisible(true);
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
}



