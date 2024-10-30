package PLAYER;

public class Player {
    private String nume;
    private int hp = 30;
    private int mana;
    private int atk = 0;
    private boolean alive = true;
    private boolean weaponequiped = false;
    static Weapon weapon;// lmao the name
    private boolean lifesteal;
    private boolean divineshield;
    // Changed hand max to 10
    // Sunt 10 carti in mana 30 in deck, deck-ul nu trebuie salvat decat in fisierul
    // cu deck si cand e nevoie
    // sa tragi o carte se va apela metoda si se introduce in hand
    private Object[] hand = new Object[10];// vector cu cartile (atat, cartile)

    // Changed 30 to 10 for max hand space
    // nu inteleg denumirea pt setCarti si tipObject✅
    // setCarti (ar trebui setHand?), tipObject (doar object?)✅
    // va trebui getter (care returneaza obiectul si va fi apelat cu indexul de care
    // e nevoie)✅
    // si setter pentru hand(cand dai draw la o carte sau adaugi una datorita altei
    // carti care va avea ca argument obiectul✅
    // deci atunci hand va fi privat

    public void setMana(int mana) {

        this.mana = mana;

    }

    public int getMana() {

        return this.mana;
    }

    public void setManaConsuption(int manaminus) {

        this.mana = this.mana - manaminus;

    }

    public void setHand(int i, Object object) {
        if (i > 10)
            return;

        hand[i] = object;

    }

    public Object getHandIndex(int i) {
        return hand[i];

    }

    public boolean getDs() {
        return divineshield;
    }

    public Player(String nume) {
        this.nume = nume;

    }

    public void setHpDmg(int n) {
        if (this.hp - n <= 0)
            alive = false;
        this.hp = this.hp - n;

    }

    // changed Heal to heal to match project naming schemes
    public void heal(int n) {

        this.hp = this.hp + n;
    }

    // De ce weapon type? cred ca merge doar Weapon weapon, initializezi obiectul
    public void setWeapon(Weapon type)// cred ca merge?
    {
        this.weapon = type;

    }

    // i mean nu sunt sigur daca e nevoie de asta, daca Hero-ul moare(player, e gata
    // jocul), imi explici dupa
    public void setAlive(boolean n) {
        this.alive = n;
    }

    public boolean getAlive() {
        return alive;

    }

    public int getAtk() {

        return this.atk;

    }

    public int getHp() {
        return this.hp;
    }

    public void setWpCd() {

        if (getWeapon().getDurability() <= 0) {
            this.weaponequiped = false;
            weapon = null;// poat merge
        }

    }

    public boolean getWpCd() {

        return weaponequiped;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public static void main(String[] args) {
        Player testplayer = new Player("TESTER");
        Weapon arma = new WeaponTest("CUTITLETAL", 10, 10);
        Spell vraja = new Spell("MAGINE NEAGRA!!!!!!");
        testplayer.setWeapon(arma);
        Player.weapon.ceface();
        for (int i = 0; i < 30; i++) {
            testplayer.setHand(i, vraja);

        }
        for (int i = 0; i < 30; i++) {
            if (testplayer.hand[i] instanceof Spell) {
                Spell aux = (Spell) testplayer.hand[i];
                System.out.print(i);
                aux.afisare();
            }

        }

    }
}