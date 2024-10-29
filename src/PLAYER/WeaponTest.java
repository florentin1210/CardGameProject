package PLAYER;

class WeaponTest extends Weapon{
//Weapon arma=new Weapontest(armaletala,3catralioane,100kdmg);
WeaponTest(String name,int cost,int atk)
{
    super(name,cost,atk);

}

@Override
void ceface()
{

    System.out.println("FAC TEST,ARMA DE TEST");
}
    

}
