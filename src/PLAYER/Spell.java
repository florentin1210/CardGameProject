package PLAYER;


public class Spell implements Afisare{

// string name
private String nume;
private int mana;
    // string name
    public Spell(String nume,int mana)
    {
        this.nume=nume;
        this.mana=mana;


    }


@Override
public void afisare() {
    System.out.println("FAC MAGIE!!!");
    
}
    
}
