package MINION;
import PLAYER.*;
public abstract class MinionAtk {

    // variabilele incep cu litera mica deci One = one , TwoOwner = twoOwner
    public void DamageMiniononMinion(Minion One, Minion Two,Player TwoOwner) {

        if (One.getHp() - Two.getAtk() <= 0)

            One.setAlive(false);

        else
            // cred ca m-am exprimat gresit cand am descris "exchange de hp si attack)
            // va fi one.setHp(one.getHp - two.getAttack)
            // ex: one are 2 3 two are 2 3 (atk respectiv hp)
            // dupa ce oriunul dintre ei il ataca pe celalalt (in cazul asta)
            // amandoi o sa aiba 2 1 atk hp
            // ex: daca un 5/2 ataca un 2/6, 5/2 moare si 2/6 va deveni in 2/1
            One.setHp(Two.getAtk());

            // lifesteal da heal cu toata val atk-ului
            // lifesteal se intampla si daca one ia damage si moare
            if(Two.getLS()==true)
        {
            if(TwoOwner.getHp()+Two.getAtk()/5<=30)
            {
                TwoOwner.heal(Two.getAtk()/5);//nu m-am gandit la calcule
            }


        }

            // o sa mai ai de luat in considerare divine shield
            // daca minionul are divineshield nu ia dmg la interactiune
            // dupa interactiune pierde divineshield
            // la fel si pt hero

    }

//Cum fac cu lifesteal si astea lmao help
// daca un minion cu atk 2 sa zicem da damage in oricefel (fie ca el ataca sau este atacat)
    // va da heal la player cu 2 atk

//am combiat playerattack si damageminonxminion
    public void PlayerAttack(Player jucator,Minion min)
    {
        if(jucator.getHp()-min.getAtk()<=0)
        jucator.setAlive(false);
        else
            //jucator.setHp
         jucator.setHpDmg(min.getAtk());


    }
}
