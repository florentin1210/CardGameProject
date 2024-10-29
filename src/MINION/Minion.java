package MINION;
import SFX.*;

public class Minion{

String nume;
private int hp;
private int atk;
private int cost;
boolean alive=true;
boolean lifesteal;
boolean divineshield;
boolean taunt;
    public Minion(String nume,int cost)
    {

    this.nume=nume;
    this.cost=cost;
    }


public int getAtk(){

    return this.atk;
    
    }
    
    public int getHp()
    {
    return this.hp;
    }
    public int getCost()
    {


        return this.cost;
    }

}