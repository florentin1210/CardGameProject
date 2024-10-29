package PLAYER;


public class Spell implements Afisare{


String nume;

    public Spell(String nume)
    {
        this.nume=nume;


    }


@Override
public void afisare() {
    System.out.println("FAC MAGIE!!!");
    
}
    
}
