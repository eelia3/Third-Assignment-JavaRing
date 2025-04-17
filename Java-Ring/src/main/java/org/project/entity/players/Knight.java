package org.project.entity.players;

import org.project.entity.enemies.Enemy;
import org.project.object.armors.KnightArmor;
import org.project.object.consumables.Knightflask;
import org.project.object.weapons.Sword;

public class Knight extends Player {
    KnightArmor armor = new KnightArmor();

    public Knight() {
        super("Knight", 100, 20, new Sword(), new KnightArmor(), new Knightflask(), 100, 20);
        this.armor = new KnightArmor();
        this.weapon = new Sword();
        this.flasks = new Knightflask();
    }

    @Override
    public void oldTrickInTheBook(Enemy enemy) {
        if (this.getMp() > 20) {
            System.out.println(name + " performs a powerful shield bash, stunning the enemy and dealing massive damage!");
            enemy.takeDamage(weapon.getDamage() + 25);
            this.setMp(20);
        } else {
            System.out.println("Not enough MP to perform the ability!");
        }
    }
}
