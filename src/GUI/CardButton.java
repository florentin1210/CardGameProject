package GUI;

import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class CardButton extends JButton {
    private Image backgroundImage;
    private int atk;
    private int hp;
    private int cost;
    private Object card;

    public CardButton(Object card, String backgroundImagePath, int atk, int hp, int cost) {
        try {
            this.backgroundImage = ImageIO.read(new File(backgroundImagePath));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Eroare la încărcarea imaginii: " + backgroundImagePath);
        }

        this.atk = atk;
        this.hp = hp;
        this.cost = cost;
        this.card = card;

        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.setColor(Color.WHITE);

        g.drawString(String.valueOf(atk), 10, getHeight() - 10);
        g.drawString(String.valueOf(hp), getWidth() - 20, getHeight() - 10);
        g.drawString(String.valueOf(cost), 10, 20);
    }

    public void setAtk(int atk) {
        this.atk = atk;
        repaint();
    }

    public void setHp(int hp) {
        this.hp = hp;
        repaint();
    }

    public void setCost(int cost) {
        this.cost = cost;
        repaint();
    }

    public Object getCard() {
        return card;
    }
}
