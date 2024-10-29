package PLAYER;

public abstract class Weapon{

String nume;
private int durability;
private int cost;
private int atk;

public Weapon(String nume, int cost,int atk)
{
    this.nume=nume;
    this.cost=cost;
    this.atk=atk;

}



public int getCost()
{
    return this.cost;

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

    // deci daca ai weapon equipped poti ataca cu hero-ul (player) care va fi o chestie de UI
abstract void ceface();

}