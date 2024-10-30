package SFX;

import MINION.Minion;
import PLAYER.*;

// astea is metode abstracte cred, nu o sa fie salvat ca obiect au doar metode
public abstract class SpecialEffects {

    String nume;
    Player player;

    public void BattleCry(Object card) {

        if (player.getHandIndex(9) != null)// verificam daca ultima carte este ocupata
        {

            player.setHand(9, card);

        } else {
            int i = player.getLastEmptyIndex();
            player.setHand(i, card);

        }

    }

    public void BuffHand() {
        for (int i = 0; i < 9; ++i) {
            if (player.getHandIndex(i) instanceof Minion) {
                Minion aux = (Minion) player.getHandIndex(i);
                aux.addHp(2);
                aux.addAtk(i);
                player.setHand(i, aux);

            }

        }

    }

}
