package com.nano.nolight.home;

import com.badlogic.gdx.physics.box2d.Body;
import com.nano.nolight.interfaces.GameObject;

public class LivingRoom implements  GameObject{
    private Body body;
    //creating a new living room scene
    @Override
    public void render() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public Body getBody() {
        return this.body;
    }


}
