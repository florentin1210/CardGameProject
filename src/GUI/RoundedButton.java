package GUI;

import javax.swing.*;
import java.awt.*;

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
