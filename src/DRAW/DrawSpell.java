package DRAW;

import PLAYER.Spell;

import java.io.IOException;

public class DrawSpell {
    public Spell drawSpell(String line) throws IOException {
        String[] parts = line.split(", ");

        String imagePath = parts[1];
        String cardName = parts[2];
        int manaCost = Integer.parseInt(parts[3]);

        return new Spell(imagePath, cardName, manaCost);
    }
}
