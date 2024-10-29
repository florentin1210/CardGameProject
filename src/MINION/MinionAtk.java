package MINION;
import PLAYER.*;
public abstract class MinionAtk {

    public void DamageMiniononMinion(Minion One, Minion Two,Player TwoOwner) {

        if (One.getHp() - Two.getAtk() <= 0)

            One.setAlive(false);

        else
        
            One.setHp(Two.getAtk());

            if(Two.getLS()==true)
        {
            if(TwoOwner.getHp()+Two.getAtk()/5<=30)
            {
                TwoOwner.Heal(Two.getAtk()/5);//nu m-am gandit la calcule
            }


        }

    }

//Cum fac cu lifesteal si astea lmao help


//am combiat playerattack si damageminonxminion
    public void PlayerAttack(Player jucator,Minion min)
    {
        if(jucator.getHp()-min.getAtk()<=0)
        jucator.setAlive(false);
        else
         jucator.setHpDmg(min.getAtk());


    }
}
