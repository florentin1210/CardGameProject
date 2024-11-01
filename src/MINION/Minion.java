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
    private boolean canAttackBool=false;
    private boolean rush;
    private String image = "/SRC/PLAYER/hero.png";

    public String getImageString() {
        return image;
    }

    public Minion(String imageloc,String nume, String tribe, int atk, int hp, int mana, boolean lifesteam, boolean divineshield,boolean taunt,boolean poisonBool,boolean chargeBool,boolean rushBool) {
        this.image=imageloc;
        this.nume = nume;
        this.tribeString = tribe;
        this.atk = atk;
        this.hp = hp;
        this.costmana = mana;
        this.lifesteal = lifesteam;
        this.divineshield = divineshield;
        this.taunt=taunt;
        this.poisonBool=poisonBool;
        this.chargeBool=chargeBool;
        this.rushBool=rushBool;

    }
    public boolean getcanAttackBool()
    {
        return canAttackBool;

    }
public void setcanAttackBool(boolean atkb)
{

    this.canAttackBool=atkb;

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

    public void setAlive(boolean a)
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