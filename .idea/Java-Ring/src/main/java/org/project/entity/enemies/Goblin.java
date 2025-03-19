package org.project.entity.enemies;

import org.project.object.weapons.Dagger;

public class Goblin extends Enemy{
    public Goblin(){
        super(150,0,new Dagger(),"GOBLIN");
        this.weapon = new Dagger();
    }
}
