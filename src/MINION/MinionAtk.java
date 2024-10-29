package MINION;
import PLAYER.*;
public abstract class MinionAtk {

    public void DamageMiniononMinion(Minion One, Minion Two) {

        if (One.getHp() - Two.getAtk() <= 0)

            One.setAlive(false);

        else
            One.setHp(Two.getAtk());

    }

//Cum fac cu lifesteal si astea lmao help


//am combiat playerattack si damageminonxminion
    public void PlayerAttack(Player jucator,Minion min)
    {
        if(jucator.getHp()-min.getAtk()<=0)
        jucator.setAlive(false);
        else
         jucator.setHp(min.getAtk());


    }
}
