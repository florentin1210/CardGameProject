package MINION;

import SFX.*;
import PLAYER.*;
import javax.swing.*;

public class Minion {

    private String nume;
    private String tribeString;
    private int hp;
    private int atk;
    private int costmana;
    private boolean alive = true;
    private boolean lifesteal;
    private boolean divineshield;
    private boolean taunt;
    private boolean poisonBool;
    private boolean chargeBool;
    private boolean rushBool;
    private boolean canAttackBool;
    private boolean rush;
    private String image = "/SRC/PLAYER/hero.png";

    public String getImageIcon() {
        return image;
    }

    // return new Minion(cardName, tribe, attack, hp, manaCost, lifeSteal,
    // divineShield);

    public Minion(String nume, String tribe, int atk, int hp, int mana, boolean lifesteam, boolean divineshield) {

        this.nume = nume;
        this.tribeString = tribe;
        this.atk = atk;
        this.hp = hp;
        this.costmana = mana;
        this.lifesteal = lifesteam;
        this.divineshield = divineshield;

    }

    public boolean getTaunt() {
        return taunt;
    }

    public void setTaunt(boolean taunt) {
        this.taunt = taunt;
    }

    public boolean getRushBool() {
        return rush;
    }

    public boolean getPoisonBool() {
        return poisonBool;
    }

    public void setRushBool(boolean rush) {

        this.rush = rush;
    }

    public void setPoisonBool(boolean PoisonBool) {
        this.poisonBool = PoisonBool;
    }

    public void setAtk(int attack) {

        this.atk = attack;
    }

    public void setLS(boolean lifestealbool) {
        this.lifesteal = lifestealbool;

    }

    public boolean getLS() {

        return lifesteal;
    }

    public int getAtk() {

        return this.atk;

    }

    public int getHp() {
        return this.hp;
    }

    public int getCost() {

        return this.costmana;
    }

    public boolean getDs() {
        return this.divineshield;

    }

    public void setDs(boolean a) {

        this.divineshield = a;
    }

    public void setAlive(boolean a)// Daca minionul moare,elimina de pe board
    {
        this.alive = a;
    }

    public void setHp(int n) {
        if (this.hp - n <= 0)
            this.alive = false;
        this.hp = this.hp - n;
    }

    public void addHp(int n) {
        this.hp = this.hp + n;

    }

    public void addAtk(int n) {
        this.atk = this.atk + n;

    }
}