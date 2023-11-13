package com.nano.nolight.interfaces;

import com.badlogic.gdx.physics.box2d.Body;

public interface GameObject {
    void render();
    void dispose();
    Body getBody();

}
