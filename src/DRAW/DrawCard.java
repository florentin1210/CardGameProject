package DRAW;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class DrawCard {
    protected static ArrayList<Object> deck=new ArrayList<>();




    public static void loadDeck(String filePath) {
        //filePath = src/DRAW/deck.txt;
        //ca sa folositi unde e nevoie

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String type = parts[0];

                switch (type) {
                    case "Minion":
                        //in fisier: type, name, tribe, attack, hp, manaCost, boolean lifeSteal, boolean divineShield
                        DrawMinion drawMinion = new DrawMinion();
                        deck.add(drawMinion.drawMinion(line));
                        break;
                    case "Spell":
                        //in fisier: idk
                        DrawSpell drawSpell = new DrawSpell();
                        deck.add(drawSpell.drawSpell(line));
                        break;
                    case "Weapon":
                        //in fisier: type, name, attack, hp/durability, manaCost, boolean lifeSteal, boolean divineShield
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

    //inainte de draw card trebuie sa dai load la deck cu metoda loadDeck de mai sus!!
    public static Object drawCard() {
        if (!deck.isEmpty()) {
            Random random = new Random();
            int i = random.nextInt(deck.size());
            return deck.remove(i);
        }
        return null;
    }
}
