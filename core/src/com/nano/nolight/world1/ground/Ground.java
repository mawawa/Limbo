package com.nano.nolight.world1.ground;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.nano.nolight.interfaces.GameObject;

public class Ground implements GameObject {
    private final Fixture fixture;
    Body body;
    PolygonShape shape;


    public Ground(World world){
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.x = 0;
        bodyDef.position.y = 0;
        bodyDef.type = BodyDef.BodyType.StaticBody;
        this.body = world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        this.shape = new PolygonShape();
        this.shape.setAsBox(10, 1);
        fixtureDef.shape = shape;
        this.fixture = body.createFixture(fixtureDef);
    }

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
