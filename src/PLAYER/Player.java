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
    Object[] hand=new Object[30];//vector cu cartile/spells/etc




    public void setCarti(int i,Object tipObject)
    {   if(i>30)
        return;

        hand[i]=tipObject;

    }

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
        Spell vraja=new Spell("MAGINE NEAGRA!!!!!!");
        testplayer.setWeapon(arma);
        Player.weapon.ceface();
        for(int i=0;i<30;i++)
        {
            testplayer.setCarti(i, vraja);

        }
        for(int i=0;i<30;i++)
        {
            if(testplayer.hand[i] instanceof Spell)
            {
                Spell aux=(Spell) testplayer.hand[i];
                System.out.print(i);
                aux.afisare();
            } 

        }


    }
}