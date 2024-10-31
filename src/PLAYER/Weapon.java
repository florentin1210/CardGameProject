package PLAYER;
import javax.swing.*;
public class Weapon{

String nume;
private int durability=10;//cred
private int cost;
private int atk;
private String image="Hero.png";



public Weapon(String iamge,String nume,int atk,int durability, int cost)
{
    this.nume=nume;
    this.cost=cost;
    this.atk=atk;
    this.image=iamge;
    this.cost=cost;

}

//locatie image, cardName, attack, durability, manaCost
public String getImageString()
    {
        return image;
    }
public int getCost()
{
    return this.cost;

}

public void setDurability(int damage)
{
    this.durability=this.durability-damage;


}

public int getDurability()
{
    return this.durability;
}
public int getAtk()
{
    return this.atk;
}
//functii de baza ale atacurilor

public void commitAtk(int n)
{

}


    // deci daca ai weapon equipped poti ataca cu hero-ul (player) care va fi o chestie de UI

}