package org.project.entity.players;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;
import org.project.object.consumables.Flask;

// TODO: UPDATE IMPLEMENTATION
public abstract class Player {
    public String name;
    Weapon weapon;

    Armor armor;
    private int hp;
    private int maxHP;
    Flask flasks;
    private int mp;
    private int maxMP;
    private boolean isDefending;

    public Player(String name, int hp, int mp, Weapon weapon, Armor armor, Flask flasks, int mhp, int mmp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.maxHP = mhp;
        this.maxMP = mmp;
        this.weapon = weapon;
        this.armor = armor;
        this.isDefending = false;
    }

    //@Override
    public void attack(Entity target) {
        target.takeDamage(weapon.getDamage());
    }

    //@Override
    public void defend() {
        this.isDefending = true;
    }

    public void stopDefending() {
        this.isDefending = false;
    }

    public boolean isDefending() {
        return isDefending;
    }

    public void flaskheal() {
        this.hp += flasks.hflask();
        if (this.hp > maxHP) {
            this.hp = maxHP;
        }
    }

    public void flaskmp() {
        this.mp += flasks.mflask();
        if (this.hp > maxHP) {
            this.mp = maxMP;
        }
    }

    // TODO: (BONUS) UPDATE THE FORMULA OF TAKING DAMAGE
    //@Override
    public void takeDamage(int damage) {
        if (!isDefending) {
            hp -= damage * (1 - (armor.getDefense() / (armor.getDefense() + 50.0)));
        }
    }

    //@Override
    public void heal(int health) {
        hp += health;
        if (hp > maxHP) {
            hp = maxHP;
        }
    }

    public void hp(int directdamage) {
        this.hp -= directdamage;
    }

    //@Override


    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    //@Override
    public int getMaxHP() {
        return maxHP;
    }

    public int getMp() {
        return mp;
    }

    //@Override
    public int getMaxMP() {
        return maxMP;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getArmor() {
        return armor.getDefense();

    }
public void setMp(int MP){
        mp -=MP;
}
    public void oldTrickInTheBook(Enemy enemy) {};
}
