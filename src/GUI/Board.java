package GUI;

import javax.swing.*;
import java.awt.*;
import java.lang.String;

public class Board {
    public Board(){
        JFrame main = new JFrame("Hearthsnot");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(1920,1080);
        main.setLayout(new GridLayout(2,1));

        JPanel player1Panel = new JPanel();

        player1Panel.setLayout(new GridLayout(4,1));

        JPanel handPanel = new JPanel();
        // wallah help me

        JPanel manaPanel = new JPanel();

    }
}
