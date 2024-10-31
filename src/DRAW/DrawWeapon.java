package DRAW;

import PLAYER.Weapon;

import java.io.IOException;

public class DrawWeapon {
    public Weapon drawWeapon(String line) throws IOException {
        String[] parts = line.split(", ");

        String cardName = parts[1];
        int manaCost = Integer.parseInt(parts[5]);
        int attack = Integer.parseInt(parts[3]);

        return new Weapon(cardName, manaCost, attack);//ciuci:vezi ca clasa este tip spell si dai return la weapon;
        //ma gandesc ca inca nu ii terminata clasa weapon, adaug pe parcurs
    }
}
