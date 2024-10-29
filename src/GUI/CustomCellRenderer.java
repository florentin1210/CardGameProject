package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomCellRenderer extends DefaultTableCellRenderer {
    private final String[] targetString;

    public CustomCellRenderer(String[] targetString) {
        this.targetString = targetString;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        cell.setBackground(Color.WHITE);

        for (String colorValue : targetString) {
            if (value != null && value.equals(colorValue)) {
                cell.setBackground(Color.GRAY);
                break;
            }
        }

        cell.setForeground(Color.BLACK);

        return cell;
    }
}
