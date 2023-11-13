package com.nano.nolight.world1.player;

import com.nano.nolight.interfaces.GameObject;

public class PlayerOne implements GameObject {

    public PlayerOne(){
        System.out.println("created a new player one.");
    }

    @Override
    public void render() {
        System.out.println("Rendering player");
    }

    @Override
    public void dispose() {
        System.out.println("Disposing waste.");
    }
}
