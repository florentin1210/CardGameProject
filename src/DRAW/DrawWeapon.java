package DRAW;

import PLAYER.Spell;
import PLAYER.Weapon;

import java.io.BufferedReader;
import java.io.IOException;

public class DrawWeapon {
    public Spell drawWeapon(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        String[] parts = line.split(" ");

        String cardName = parts[1];
        int manaCost = Integer.parseInt(parts[5]);
        int attack = Integer.parseInt(parts[3]);

        return new Weapon(cardName, manaCost, attack);
        //ma gandesc ca inca nu ii terminata clasa weapon, adaug pe parcurs
    }
}
