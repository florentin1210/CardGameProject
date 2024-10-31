package DRAW;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class DrawCard {
    protected ArrayList<Object> deck;

    public DrawCard() {
        deck = new ArrayList<>();
    }


    public void loadDeck(String filePath) throws IOException {
        //filePath = src/DRAW/deck.txt;
        //ca sa folositi unde e nevoie

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String type = parts[0];

                switch (type) {
                    case "Minion":
                        DrawMinion drawMinion = new DrawMinion();
                        deck.add(drawMinion.drawMinion(reader));
                        break;
                    case "Spell":
                        DrawSpell drawSpell = new DrawSpell();
                        deck.add(drawSpell.drawSpell(reader));
                        break;
                    case "Weapon":
                        DrawWeapon drawWeapon = new DrawWeapon();
                        deck.add(drawWeapon.drawWeapon(reader));
                        break;
                    default:
                        System.out.println("ERROR:(deck) Unknown card type: " + type);
                }
            }
        }
    }

    public Object drawCard() {
        if (!deck.isEmpty()) {
            Random random = new Random();
            int i = random.nextInt(deck.size());
            return deck.remove(i);
        }
        return null;
    }
}
