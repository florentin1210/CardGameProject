package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import PLAYER.*;

public class Board {
    private Player player1, player2;
    private int buttonCount;
    private final int MAX_BUTTONS = 10;
    private ArrayList<JButton> handButtons;

    public Board(){
        JFrame main = new JFrame("Hearthsnot");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(1920,1080);
        main.setLayout(new GridLayout(2,1));

        RoundedButton endTurn = new RoundedButton("End turn");

        JPanel player1Panel = new JPanel();

        player1Panel.setLayout(new GridLayout(4,1));

        JPanel handPanel = new JPanel();
        handPanel.setLayout(new FlowLayout());
        handButtons = new ArrayList<>();



        JPanel manaPanel = new JPanel();

        JTable manaTable = new JTable(1,10);
        //manaTable.setDefaultRenderer(Object.class, new CustomCellRenderer(player1.getMana));
        main.add(manaPanel);

        JPanel heroPanel = new JPanel();
        JLabel weaponLabel = new JLabel();



    }
    private void addButtonToPanel(JPanel handPanel, JFrame main) {
        if (buttonCount < MAX_BUTTONS) {
            JButton newButton = new JButton("Button " + (buttonCount + 1));
            handPanel.add(newButton);
            handPanel.revalidate();
            handPanel.repaint();
            buttonCount++;
        } else {
            JOptionPane.showMessageDialog(main, "Maximum number of buttons reached!");
        }
    }
}
