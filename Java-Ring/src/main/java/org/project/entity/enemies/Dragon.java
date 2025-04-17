package org.project.entity.enemies;
import org.project.object.weapons.DragonClaw;

import org.project.entity.players.Player;

public class Dragon extends Enemy {
    public Dragon() {
        super(200, 100, new DragonClaw(), "Dragon");
    }

    @Override
    public void speshialmove(Player player) {
        if (this.getMp() >= 30) {
            System.out.println(name + " breathes fire, dealing massive damage and ignoring defense!");
            player.hp(50);
            this.setMp(30);
        } else {
            System.out.println(name + " doesn't have enough MP to use the special move!");
        }
    }
}
