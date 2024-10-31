package PLAYER;


public class Spell implements Afisare{

// string name
private String nume;
private int mana;
private String image="";
    public Spell(String image,String nume,int mana)
    {
        this.nume=nume;
        this.mana=mana;
        this.image=image;

    }
//spell: locatie image, cardName, manaCost
public String getImageString()
    {
        return image;
    }
public int getCost()
{
    return this.mana;

}


@Override
public void afisare() {
    System.out.println("FAC MAGIE!!!");
    
}
    
}
