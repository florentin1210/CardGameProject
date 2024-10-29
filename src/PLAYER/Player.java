package PLAYER;

public class Player {
    private String nume;
    private int hp=30;
    private int mana;
    private int atk = 0;
    private boolean alive=true;
    private boolean weaponequiped=false;
    static Weapon weapon;//lmao the name
    boolean lifesteal;
    boolean divineshield;
    Object[] hand=new Object[30];//vector cu cartile

    public Player(String nume) {
        this.nume = nume;

    }
    public void setHpDmg(int n)
    {
        this.hp=this.hp-n;


    }
    public void Heal(int n)
    {

        this.hp=this.hp+n;
    }
    public void setWeapon(Weapon type)//cred ca merge?
   {
        this.weapon=type;

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



    public static void main(String[] args) 
    {
        Player testplayer=new Player("TESTER");
        Weapon arma=new WeaponTest("CUTITLETAL",10,10);
        testplayer.setWeapon(arma);
        Player.weapon.ceface();


    }
}