package GUI;

import javax.swing.*;
import java.awt.*;

public class WeaponLabel extends JLabel {
    private Image backgroundImage;
    private int atk;
    private int durability;
    private int cost;

    public WeaponLabel(Image backgroundImage, int atk, int durability, int cost) {
        this.backgroundImage = backgroundImage;
        this.atk = atk;
        this.durability = durability;
        this.cost = cost;
        setOpaque(false);
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

        g.drawString(String.valueOf(durability), getWidth() - 20, getHeight() - 10);

        g.drawString(String.valueOf(cost), 10, 20);
    }

    public void setAtk(int atk) {
        this.atk = atk;
        repaint();
    }

    public void setDurability(int durability) {
        this.durability = durability;
        repaint();
    }

    public void setCost(int cost) {
        this.cost = cost;
        repaint();
    }
}