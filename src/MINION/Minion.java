package MINION;
import SFX.*;
import PLAYER.*;

public class Minion {

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

    public void setLS(boolean lifestealbool)
    {
       this.lifesteal=lifestealbool;

    }
    public boolean getLS()
    {

        return lifesteal;
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
    public boolean getDs()
    {
return this.divineshield;

    }
    public void setDs(boolean a)
    {

        this.divineshield=a;
    }
    
    public void setAlive(boolean a)//Daca minionul moare,elimina de pe board
    {
        this.alive=a;
    }
    public void setHp(int n)
    {
        if(this.hp-n<=0)
        this.alive=false;
        this.hp=this.hp-n;
    }
    public void addHp(int n)
    {
        this.hp=this.hp+n;

    }
    public void addAtk(int n)
    {
        this.atk=this.atk+n;

    }
}