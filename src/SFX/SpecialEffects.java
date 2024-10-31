package SFX;

import MINION.Minion;
import PLAYER.*;

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

}
