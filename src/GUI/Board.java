package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.IOException;

import MINION.*;
import PLAYER.*;
import DRAW.*;

public class Board{
    private Player player1 = new Player("George");
    private Player player2 = new Player("George2");

    private int handButtonCount;
    private final int HANDMAX_BUTTONS = 10;
    private ArrayList<CardButton> handCards = new ArrayList<>();

    private int boardButtonCount;
    private final int BOARDMAX_BUTTONS = 7;
    private ArrayList<CardButton> boardCards;

    private Object cardPlayed;
    private Boolean handCardIsSelected = false;
    private int cardPlayedIndex;

    private String deckFilePath = "SRC/DRAW/deck.txt";

    public Board(){
        for(int i = 0; i<3; i++){
            DrawCard.loadDeck(deckFilePath);
            player1.addHand(DrawCard.drawCard());
        }
        for(int i = 0;i<4;i++){
            DrawCard.loadDeck(deckFilePath);
            player2.addHand(DrawCard.drawCard());
        }

        JFrame main = new JFrame("Hearthsnot");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(1920,1080);
        main.setLayout(new GridLayout(2,1));

        RoundedButton endTurn = new RoundedButton("End turn");
        //player1 setmana getmana ++
        // for treci prin toti minionii de pe board si le schimbi canAttack in true

        // action listener care schimba action listener la butoanele de pe handPanel si boardPanel

        JPanel player1Panel = new JPanel();

        player1Panel.setLayout(new GridLayout(4,1));

        JPanel handPanel = new JPanel();
        handPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        for(int i = 0;i<player1.getHandSize();i++){
            addCardToHandPanel(player1, (Minion)player1.getHand(i), handPanel ,main);
        }
        //for(int i = 0;i < player1.getHandSize();i++){
        //CardButton cartea = handCards.get(0);
        //cartea.addActionListener(new ActionListener() {
        //    @Override
        //    public void actionPerformed(ActionEvent e) {
        //
        //    }
        //});
        //}

        JPanel manaPanel = new JPanel();

        JTable manaTable = new JTable(1,10);
        manaTable.setDefaultRenderer(Object.class, new CustomCellRenderer(player1.getMana()));
        main.add(manaPanel);

        JPanel heroPanel = new JPanel();
        heroPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        if(player1.getWeaponIsEquipped()){
            WeaponLabel weaponLabel = new WeaponLabel(
                    player1.getWeapon().getImageString(),
                    player1.getWeapon().getAtk(),
                    player1.getWeapon().getDurability(),
                    player1.getWeapon().getCost());
            heroPanel.add(weaponLabel);
        }
        HeroButton heroButton = new HeroButton(player1.getImageString(),player1.getAtk(),player1.getHp());
        // daca are weapon equipped pui action listener de atk

        heroPanel.add(heroButton);
        RoundedButton heroPowerButton = new RoundedButton("Summon a 1/1");
        heroPanel.add(heroPowerButton);

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        RoundedButton playCardButton = new RoundedButton("Play card!");

        playCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if cardPlayed true  addCardToBoard(handCards de cardIndexButton)
            }
        });
        boardPanel.add(playCardButton);

        // for care trece prin toate cartile din board,verifica canAttack, daca true action listener sa poata ataca
        // adica cand apesi pe el creezi action listener la minionii de pe board si hero ul inamicului
        // daca are minioni cu taunt doar ei au action listener

    }
    private void addCardToHandPanel(Player player, Minion minion, JPanel handPanel, JFrame main) {
        if (handButtonCount < HANDMAX_BUTTONS) {
            CardButton newCard = new CardButton(minion, minion.getImageString(),minion.getAtk(),minion.getHp(),minion.getCost());
            handPanel.add(newCard);

            handCards.add(newCard);

            handPanel.revalidate();
            handPanel.repaint();
            handButtonCount++;
            newCard.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardPlayed = newCard.getCard();
                    int minionCost = minion.getCost();
                    if(minion.getCost() > player.getMana()) JOptionPane.showMessageDialog(main, "You don't have enough mana");
                    if(!handCardIsSelected && (minionCost <= player.getMana())) handCardIsSelected = true;
                    else JOptionPane.showMessageDialog(main,
                            "You already selected a card to play!");
                    cardPlayedIndex = handButtonCount;
                }
            });
        } else {
            JOptionPane.showMessageDialog(main, "Maximum number of cards reached!");
        }
    }
    private void addCardToBoardPanel(Minion minion, JPanel boardPanel, JFrame main){
        if(boardButtonCount < BOARDMAX_BUTTONS){
            CardButton newCard = new CardButton(minion, minion.getImageString(),minion.getAtk(),minion.getHp(),minion.getCost());

            boardPanel.add(newCard);

            boardCards.add(newCard);

            boardPanel.revalidate();
            boardPanel.repaint();
            boardButtonCount++;
        }
    }
}
