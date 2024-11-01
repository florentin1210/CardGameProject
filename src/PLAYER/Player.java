package PLAYER;

import java.util.ArrayList;
import javax.swing.*;

public class Player {
    private String name;
    private int hp = 30;
    private int mana;
    private int atk = 0;
    private boolean alive = true;
    private boolean WeaponIsEquipped = false;
   private Weapon weapon;// lmao the name
    private boolean lifesteal;
    private boolean divineshield;
    private boolean chargeBool;
    private String image="/SRC/PLAYER/hero.png";
    private ArrayList<Object> hand = new ArrayList<>();
    private ArrayList<Object> deck=new ArrayList<>();

    public Player(String name) {
        this.name = name;

    }

    public void loadDeck(Object object)
    {
        this.deck.add(object);


    }
    public Object getDeckIndex(int i)
    {
        return deck.get(i);


    }
    public int getHandSize() {
        return hand.size();

    }
    public String getImageString()
    {
        return image;
    }
    
    public void setHandIndex(int i,Object object)
    {
        this.hand.set(i,object);

    }
    public void setMana(int mana) {

        this.mana = mana;

    }

    public int getMana() {

        return this.mana;
    }

    public void setManaConsuption(int manaminus) {

        this.mana = this.mana - manaminus;

    }

    public void addHand(Object object) {
        hand.add(object);

    }

    public void removeHand(int i) {

        hand.remove(i);
    }

    /*
     * public int getLastEmptyIndex() {
     * for (int i = 0; i < 10; ++i) {
     * 
     * if (hand[i] == null) {
     * return i;
     * }
     * }
     * return 9;//ultimul
     * 
     * }
     */
    public Object getHandIndex(int i) {
        return hand.get(i);

    }
    public Object getHand(int i)
    {
        return hand.get(i);

    }
    public boolean getDs() {
        return divineshield;
    }

    public void setHpDmg(int n) {
        if (this.hp - n <= 0)
            alive = false;
        this.hp = this.hp - n;

    }

    // changed Heal to heal to match project naming schemes
    public void heal(int n) {

        this.hp = this.hp + n;
    }

    // De ce weapon type? cred ca merge doar Weapon weapon, initializezi obiectul
    public void setWeapon(Weapon type)// cred ca merge?
    {
        this.weapon = type;

    }

    public void setAlive(boolean n) {
        this.alive = n;
    }

    public boolean getAlive() {
        return alive;

    }

    public int getAtk() {

        return this.atk;

    }

    public int getHp() {
        return this.hp;
    }

    public boolean getWeaponIsEquipped() {

        return WeaponIsEquipped;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setChargeBool(boolean b) {
        this.chargeBool=b;
    }
public boolean getChargeBool()
{
return chargeBool;

}
}