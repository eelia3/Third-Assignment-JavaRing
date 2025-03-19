package org.project.entity.players;

import org.project.entity.enemies.Enemy;
import org.project.object.armors.AsassinArmor;
import org.project.object.consumables.Assasinflask;
import org.project.object.consumables.Flask;
import org.project.object.consumables.Knightflask;
import org.project.object.weapons.*;

// TODO: UPDATE IMPLEMENTATION
public class Assasin extends Player {
    public Assasin() {
        super("Assassin", 100, 40, new Dagger(), new AsassinArmor(), new Assasinflask(), 100, 40);
        this.flasks = new Assasinflask();
        this.weapon = new Dagger();
        this.armor = new AsassinArmor();
    }

    @Override
    public void oldTrickInTheBook(Enemy enemy) {
        if(this.getMp()>30) {
            System.out.println(name + " becomes invisible, avoiding all attacks and striking critically!");
            enemy.takeDamage(weapon.getDamage() * 2);
            this.setMp(30);
        }
        else System.out.println("mp was not enough");
    }
}

