package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import MINION.*;
import PLAYER.*;

public class Board {
    private Player player1 = new Player();
    private Player player2 = new Player();

    private int handButtonCount;
    private final int HANDMAX_BUTTONS = 10;
    private ArrayList<CardButton> handCards = new ArrayList<>();;

    private int boardButtonCount;
    private final int BOARDMAX_BUTTONS = 7;
    private ArrayList<CardButton> boardButtons;

    public Board(){
        for(int i = 0; i<3; i++){
            player1.getHand[i] = drawCard();
        }
        for(int i = 0;i<4;i++){
            player2.getHand[i] = drawCard();
        }


        JFrame main = new JFrame("Hearthsnot");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(1920,1080);
        main.setLayout(new GridLayout(2,1));

        RoundedButton endTurn = new RoundedButton("End turn");

        JPanel player1Panel = new JPanel();

        player1Panel.setLayout(new GridLayout(4,1));

        JPanel handPanel = new JPanel();
        handPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        for(int i = 0;i<player1.getHandSize;i++){
            addCardToPanel(player1.getHand[i], handPanel,main);
        }

        JPanel manaPanel = new JPanel();

        JTable manaTable = new JTable(1,10);
        //manaTable.setDefaultRenderer(Object.class, new CustomCellRenderer(player1.getMana));
        main.add(manaPanel);

        JPanel heroPanel = new JPanel();
        heroPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        if(player1.getWeaponIsEquipped()){
            WeaponLabel weaponLabel = new WeaponLabel(
                    player1.getWeapon().getImageIcon,
                    player1.getWeapon().getAtk(),
                    player1.getWeapon().getDurability(),
                    player1.getWeapon().getCost());
            heroPanel.add(weaponLabel);
        }



        JPanel boardPanel = new JPanel();


    }
    private void addCardToPanel(Minion minion, Panel handPanel, JFrame main) {
        if (handButtonCount < HANDMAX_BUTTONS) {
            CardButton newCard = new CardButton(minion.getImageIcon,minion.getAtk(),minion.getHp(),minion.getCost);
            handPanel.add(newCard);

            handCards.add(newCard);

            handPanel.revalidate();
            handPanel.repaint();
            handButtonCount++;
        } else {
            JOptionPane.showMessageDialog(main, "Maximum number of cards reached!");
        }
    }
}
