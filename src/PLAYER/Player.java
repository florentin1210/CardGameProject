package PLAYER;


public class Player{
    private String nume;
    private int hp;
    private int mana;
    private int atk=0;


    public Player(String nume)
    {
        this.nume=nume;

    }
    public int getAtk(){

        return this.atk;
        
        }
        
        public int getHp()
        {
        return this.hp;
        }
public int getMana()
{
    return this.mana;
}


}