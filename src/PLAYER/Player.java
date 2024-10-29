package PLAYER;

public class Player {
    private String nume;
    private int hp=30;
    private int mana;
    private int atk = 0;
    private boolean alive=true;
    boolean lifesteal;
    boolean divineshield;
    Object[] hand=new Object[30];//vector cu cartile

    public Player(String nume) {
        this.nume = nume;

    }
    public void setHp(int n)
    {
        this.hp=this.hp-n;


    }
    
   public void setAlive(boolean n)
   {
    this.alive=n;
   }
    public int getAtk() {

        return this.atk;

    }

    public int getHp() {
        return this.hp;
    }

    public int getMana() {
        return this.mana;
    }

}