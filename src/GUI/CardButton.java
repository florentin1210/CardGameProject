package GUI;

import javax.swing.*;
import java.awt.*;

public class CardButton extends JButton {
    private Image backgroundImage;
    private int leftNumber;
    private int rightNumber;

    public CardButton(Image backgroundImage, int leftNumber, int rightNumber) {
        this.backgroundImage = backgroundImage;
        this.leftNumber = leftNumber;
        this.rightNumber = rightNumber;
        setContentAreaFilled(false); // elimină fundalul implicit al butonului
        setFocusPainted(false); // elimină bordura când butonul este focusat
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.setColor(Color.WHITE);

        g.drawString(String.valueOf(leftNumber), 10, getHeight() - 10);

        g.drawString(String.valueOf(rightNumber), getWidth() - 20, getHeight() - 10);
    }

    public void setLeftNumber(int leftNumber) {
        this.leftNumber = leftNumber;
        repaint();
    }

    public void setRightNumber(int rightNumber) {
        this.rightNumber = rightNumber;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        ImageIcon icon = new ImageIcon("path/to/image.jpg");
        CardButton button = new CardButton(icon.getImage(), 5, 10);

        frame.setLayout(new FlowLayout());
        frame.add(button);

        frame.setVisible(true);
    }
}
