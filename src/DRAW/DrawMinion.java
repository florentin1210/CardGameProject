package DRAW;

import MINION.Minion;

import java.io.BufferedReader;
import java.io.IOException;

public class DrawMinion {
    public Minion drawMinion(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        String[] parts = line.split(" ");

        String cardName = parts[1];
        String tribe = parts[2].equals("null") ? null : parts[2];
        int attack = Integer.parseInt(parts[3]);
        int hp = Integer.parseInt(parts[4]);
        int manaCost = Integer.parseInt(parts[5]);
        boolean lifeSteal = Boolean.parseBoolean(parts[6]);
        boolean divineShield = Boolean.parseBoolean(parts[7]);

        return new Minion(cardName, tribe, attack, hp, manaCost, lifeSteal, divineShield);

        /*
        Ciuci draga am envoie de un constructor asa (fa inca unu daca ai nevoie de cel original)

        public ClasaMinionTEST(String cardName, String tribe, int attack, int hp, int manaCost, boolean lifeSteal, boolean divineShield) {
            this.name = cardName;
            this.tribe = tribe;
            this.attack = attack;
            this.hp = hp;
            this.manaCost = manaCost;
            this.lifeSteal = lifeSteal;
            this.divineShield = divineShield;
        }*/
    }
}
