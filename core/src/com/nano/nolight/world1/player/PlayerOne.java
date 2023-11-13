package com.nano.nolight.world1.player;

import com.badlogic.gdx.physics.box2d.*;
import com.nano.nolight.interfaces.GameObject;

public class PlayerOne implements GameObject {
    private final Fixture fixture;
    Body body;
    CircleShape shape;
    
    public PlayerOne(World world){
        //define the player body
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.x = 5;
        bodyDef.position.y = 5;
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        FixtureDef fixtureDef = new FixtureDef();
        shape = new CircleShape();
        shape.setRadius(2f);
        fixtureDef.shape = shape;
        fixtureDef.friction = 1;
        fixtureDef.density = 1;
        fixtureDef.restitution = 1; 
        
        this.body = world.createBody(bodyDef);
        this.fixture = body.createFixture(fixtureDef);
    }

    @Override
    public void render() {
        System.out.println("Rendering player");
    }

    @Override
    public void dispose() {
        System.out.println("Disposing waste.");
    }

    @Override
    public Body getBody() {
        return this.body;
    }
}
