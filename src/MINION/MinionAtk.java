package MINION;

import PLAYER.*;

public abstract class MinionAtk {

    // variabilele incep cu litera mica deci One = one , TwoOwner = twoOwner

    public void damageMinionPlayer(Minion one, Player two) {

        if (one.getDs() == true) {
            two.setHpDmg(one.getAtk());

        }

        else {
            two.setHpDmg(one.getAtk());
            one.setHp(two.getAtk());

        }

    }

    public void damageMiniononMinion(Minion one, Minion two, Player twoOwner) {

        if (one.getDs() == true) {

            one.setDs(false);
            two.setHp(one.getAtk());
        } else

        if (one.getHp() - two.getAtk() <= 0 && two.getLS() == true)

        {
            one.setAlive(false);
            twoOwner.heal(two.getAtk());

        } else

        if (one.getHp() - two.getAtk() <= 0)

            one.setAlive(false);

        else
            // cred ca m-am exprimat gresit cand am descris "exchange de hp si attack)
            // va fi one.setHp(one.getHp - two.getAttack) ---- pai nu asta face functia?
            // two.getatk==> Hp player-atk de la minion
            // ex: one are 2 3 two are 2 3 (atk respectiv hp)
            // dupa ce oriunul dintre ei il ataca pe celalalt (in cazul asta)
            // amandoi o sa aiba 2 1 atk hp
            // ex: daca un 5/2 ataca un 2/6, 5/2 moare si 2/6 va deveni in 2/1
            // verificat tot✅
            one.setHp(two.getAtk());
        two.setHp(one.getAtk());
        // lifesteal da heal cu toata val atk-ului ✅
        // lifesteal se intampla si daca one ia damage si moare ✅
        if (two.getLS() == true) {
            if (twoOwner.getHp() + two.getAtk() / 5 <= 30) {
                twoOwner.heal(two.getAtk());
            }

        }

        // o sa mai ai de luat in considerare divine shield
        // daca minionul are divineshield nu ia dmg la interactiune
        // dupa interactiune pierde divineshield
        // la fel si pt hero

    }

    // Cum fac cu lifesteal si astea lmao help
    // daca un minion cu atk 2 sa zicem da damage in oricefel (fie ca el ataca sau
    // este atacat)
    // va da heal la player cu 2 atk

    // am combiat playerattack si damageminonxminion
    public void playerAttack(Player player, Minion min) {
       
            if (player.getDs() == true) {
                min.setHp(player.getAtk());

            } else   if (player.getWpCd() == true){ // jucator.setHp
                player.setHpDmg(min.getAtk());
                min.setHp(player.getAtk());

            }
        
    }

}
