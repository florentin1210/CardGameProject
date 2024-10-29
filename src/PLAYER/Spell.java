package PLAYER;


public class Spell implements Afisare{

// string name
String nume;
    // string name
    public Spell(String nume)
    {
        this.nume=nume;


    }


@Override
public void afisare() {
    System.out.println("FAC MAGIE!!!");
    
}
    
}
