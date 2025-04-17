package org.project.entity.enemies;

import org.project.entity.players.Player;
import org.project.object.weapons.Bow;

public class Skeleton extends Enemy {
    private boolean resurrected;

    public Skeleton() {
        super(100, 50, new Bow(), "Skeleton");
        this.resurrected = false;
    }

    @Override
    public void speshialmove(Player player) {
        if (this.getMp() >= 20) {
            player.hp(20);
            this.setMp(20);
        }
    }

    public boolean checkResurrect() {
        if (this.getHp() <= 0 && !resurrected) {
            resurrect();
            return true;
        }
        return false;
    }

    private void resurrect() {
        this.resurrected = true;
        this.setHp(50);
    }
}
