package DRAW;

import MINION.Minion;

import java.io.IOException;

public class DrawMinion {
    public Minion drawMinion(String line) throws IOException {
        String[] parts = line.split(", ");

        String imagePath = parts[1];
        String cardName = parts[2];
        String tribe = parts[3].equals("null") ? null : parts[3];
        int attack = Integer.parseInt(parts[4]);
        int hp = Integer.parseInt(parts[5]);
        int manaCost = Integer.parseInt(parts[6]);
        boolean lifeSteal = Boolean.parseBoolean(parts[7]);
        boolean divineShield = Boolean.parseBoolean(parts[8]);
        boolean taunt = Boolean.parseBoolean(parts[9]);
        boolean poisonBool = Boolean.parseBoolean(parts[10]);
        boolean chargeBool = Boolean.parseBoolean(parts[11]);
        boolean rushBool = Boolean.parseBoolean(parts[12]);

        return new Minion(imagePath, cardName, tribe, attack, hp, manaCost, lifeSteal, divineShield, taunt, poisonBool, chargeBool, rushBool);

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
