package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomCellRenderer extends DefaultTableCellRenderer {
    private int mana;

    public CustomCellRenderer(int mana) {
        this.mana = mana;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (column < mana) {
            cellComponent.setBackground(Color.BLUE);
        } else {
            cellComponent.setBackground(Color.WHITE);
        }

        return cellComponent;
    }
}
