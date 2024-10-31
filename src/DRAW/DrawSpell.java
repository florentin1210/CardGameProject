package DRAW;

import PLAYER.Spell;

import java.io.IOException;

public class DrawSpell {
    public Spell drawSpell(String line) throws IOException {
        String[] parts = line.split(", ");

        String cardName = parts[1];
        int manaCost = Integer.parseInt(parts[5]);

        return new Spell(cardName, manaCost);
        //ma gandesc ca inca nu ii terminata clasa spell, adaug pe parcurs
    }
}
