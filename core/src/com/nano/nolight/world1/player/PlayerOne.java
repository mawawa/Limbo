package com.nano.nolight.world1.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.*;
import com.nano.nolight.interfaces.GameObject;
import com.nano.nolight.interfaces.Player;

public class PlayerOne implements GameObject, Player {
    private final Fixture fixture;
    private int maxSpeed = 13;
    Body body;
    CircleShape shape;
    private boolean isJumping = false;

    public PlayerOne(World world){
        //define the player body
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.x = 8;
        bodyDef.position.y = 6;
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        FixtureDef fixtureDef = new FixtureDef();
        shape = new CircleShape();
        shape.setRadius(2f);
        fixtureDef.shape = shape;
        fixtureDef.friction = 1;
        fixtureDef.density = 1;
        fixtureDef.restitution = 0.1f;
        
        this.body = world.createBody(bodyDef);
        this.fixture = body.createFixture(fixtureDef);
    }

    @Override
    public void render() {
        //if is jumping
        if(!isJumping && Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            isJumping = true;
            this.body.applyLinearImpulse(0, 100,body.getWorldCenter().x, body.getWorldCenter().y, true);
        }
        //walking left
        if(Gdx.input.isKeyPressed(Input.Keys.A)&& this.body.getLinearVelocity().x < maxSpeed ){
            this.body.applyLinearImpulse(-10, 0, body.getWorldCenter().x,body.getWorldCenter().y, true  );
        }else{
           if(body.getLinearVelocity().x <0){

               this.body.applyLinearImpulse(5, 0, body.getWorldCenter().x,body.getWorldCenter().y, true  );
           }else{
               body.setLinearVelocity(0,0);
           }
        }
    }

    @Override
    public void dispose() {
        System.out.println("Disposing waste.");
    }

    @Override
    public Body getBody() {
        return this.body;
    }

    @Override
    public void spawn() {

    }

    @Override
    public void highAttack() {

    }

    @Override
    public void lowAttack() {

    }

    @Override
    public void middleAttack() {

    }

    @Override
    public void fireWeapon() {

    }

    @Override
    public void jump() {
        this.isJumping = true;
    }

    @Override
    public void crouch() {

    }

    @Override
    public void die() {

    }
}
