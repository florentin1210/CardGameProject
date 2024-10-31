package SFX;

import MINION.Minion;
import PLAYER.*;
import java.util.Random;
import java.util.ArrayList;
// astea is metode abstracte cred, nu o sa fie salvat ca obiect au doar metode
public abstract class SpecialEffects {

    String nume;
    Player player;

    public void BuffHand() {
        for (int i = 0; i < player.getHandSize(); ++i) {
            if (player.getHandIndex(i) instanceof Minion) {
                Minion aux = (Minion) player.getHandIndex(i);
                aux.addHp(2);
                aux.addAtk(2);
                player.setHandIndex(i, aux);

            }

        }

    }

    public void ToyCaptain(Minion tarim, Minion target) {

        target.setHp(tarim.getHp());
        target.setAtk(target.getAtk());

    }

    public void DroneDeconstructor(Minion minion) {
        Random rd = new Random();
        int i = rd.nextInt(4);
        switch (i) {
            case 0:
                minion.setDs(true);
                break;
            case 1:
                minion.setLS(true);
                break;
            case 2:
                minion.setRushBool(true);
                break;
            case 3:
                minion.setTaunt(true);
                break;
        }

    }

    public void SouthseaDeckhand(Player player) {

        if (player.getWeaponIsEquipped() == true)
            player.setChargeBool(true);

    }


    public void Titan(ArrayList <Minion> friendlyMinion,ArrayList <Minion> enemyMinion,Player caller)
    {
              for(int i=0;i<friendlyMinion.size();++i)
              {

                
              }


    }

}
