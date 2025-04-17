package org.project.entity.enemies;

import org.project.entity.players.Player;
import org.project.object.weapons.Weapon;

public abstract class Enemy {
    Weapon weapon;
    private int hp;
    public String name;
    private int mp;
    private boolean isDefending;

    public Enemy(int hp, int mp, Weapon weapon,String name) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.weapon = weapon;
        this.isDefending = false;
    }

    public void defend() {
        this.isDefending = true;
    }
public void setHp(int HP){
        this.hp = HP;
}
    public void stopDefending() {
        this.isDefending = false;
    }

    public void takeDamage(int damage) {
        if (!isDefending) {
            hp -= damage;
            if (hp < 0) hp = 0;
        }
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public boolean isDefending() {
        return isDefending;
    }

    public void speshialmove(Player player) {
    }

    public void setMp(int mpcost) {
        this.mp -= mpcost;
    }
}
