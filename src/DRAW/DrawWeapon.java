package DRAW;

import PLAYER.Weapon;

import java.io.IOException;

public class DrawWeapon {
    public Weapon drawWeapon(String line) throws IOException {
        String[] parts = line.split(", ");

        String imagePath = parts[1];
        String cardName = parts[2];
        int attack = Integer.parseInt(parts[3]);
        int durability = Integer.parseInt(parts[4]);
        int manaCost = Integer.parseInt(parts[5]);

        return new Weapon(imagePath, cardName, attack, durability, manaCost);
    }
}
