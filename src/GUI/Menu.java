package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String filePath) {
        try {
            backgroundImage = new ImageIcon(filePath).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

class RoundedButton extends JButton {
    private int arcWidth = 30;
    private int arcHeight = 30;

    public RoundedButton(String label) {
        super(label);
        setFocusPainted(false);
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isPressed()) {
            g2.setColor(Color.LIGHT_GRAY);
        } else {
            g2.setColor(getBackground());
        }
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

        super.paintComponent(g);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);
        g2.dispose();
    }
}

