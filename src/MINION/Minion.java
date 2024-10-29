package MINION;
import SFX.*;

public class Minion{

private String nume;
private String tribeString;
private int hp;
private int atk;
private int cost;
private boolean alive=true;
private boolean lifesteal;
private boolean divineshield;
private boolean taunt;


    public Minion(String nume,int cost,String tribe)
    {

    this.nume=nume;
    this.cost=cost;
    this.tribeString=tribe;
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

    public void setAlive(boolean a)//Daca minionul moare,elimina de pe board
    {
        this.alive=a;
    }
    public void setHp(int n)
    {

        this.hp=this.hp-n;
    }
}