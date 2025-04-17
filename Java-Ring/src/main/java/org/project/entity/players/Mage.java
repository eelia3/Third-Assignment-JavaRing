package org.project.entity.players;

import org.project.entity.enemies.Enemy;
import org.project.object.armors.KnightArmor;
import org.project.object.armors.MageArmor;
import org.project.object.consumables.Knightflask;
import org.project.object.consumables.Mageflask;
import org.project.object.weapons.Elder_Wand;
import org.project.object.weapons.Sword;

public class Mage extends Player {
    public Mage() {
        super("Mage", 100, 80, new Elder_Wand(), new MageArmor(), new Mageflask(), 100, 80);
        this.armor = new MageArmor();
        this.flasks = new Mageflask();
        this.weapon = new Elder_Wand();
    }


    @Override
    public void oldTrickInTheBook(Enemy enemy) {
        if (this.getMp() > 40) {
            System.out.println(name + " casts a powerful healing spell while damaging the enemy!");
            this.heal(30); // Heal using the defined method
            enemy.takeDamage(weapon.getDamage() + 20); // Deal damage to the enemy
            this.setMp(40); // Reduce MP by 40
        } else {
            System.out.println("Not enough MP to cast the spell!");
        }
    }

}
