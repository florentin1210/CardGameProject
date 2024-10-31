package GUI;

import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class WeaponLabel extends JLabel {
    private Image backgroundImage;
    private int atk;
    private int durability;
    private int cost;

    public WeaponLabel(String backgroundImagePath, int atk, int durability, int cost) {
        try {
            // Încărcăm imaginea din calea specificată
            this.backgroundImage = ImageIO.read(new File(backgroundImagePath));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Eroare la încărcarea imaginii: " + backgroundImagePath);
        }

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
