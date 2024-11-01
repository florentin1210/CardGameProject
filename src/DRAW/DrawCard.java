package DRAW;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class DrawCard {
    protected static ArrayList<Object> deck=new ArrayList<>();




    public static void loadDeck(String filePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String type = parts[0];

                switch (type) {
                    case "Minion":
                        //in fisier: type, image, name, tribe, attack, hp, manaCost, boolean lifeSteal, boolean divineShield, taunt, poisonBool, chargeBool, rushBool
                        DrawMinion drawMinion = new DrawMinion();
                        deck.add(drawMinion.drawMinion(line));
                        break;
                    case "Spell":
                        //in fisier: type, image, cardName, manaCost
                        DrawSpell drawSpell = new DrawSpell();
                        deck.add(drawSpell.drawSpell(line));
                        break;
                    case "Weapon":
                        //in fisier: type, image, cardName, attack, durability, manaCost
                        DrawWeapon drawWeapon = new DrawWeapon();
                        deck.add(drawWeapon.drawWeapon(line));
                        break;
                    default:
                        System.out.println("ERROR:(deck) Unknown card type: " + type);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object drawCard() {
        if (!deck.isEmpty()) {
            Random random = new Random();
            int i = random.nextInt(deck.size());
            return deck.remove(i);
        }
        return null;
    }
}
