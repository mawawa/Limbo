package com.nano.nolight.world1;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.nano.nolight.interfaces.GameObject;

public class Cameraman implements GameObject {
    private OrthographicCamera camera;
    private float cameraWidth = 19.20f*4;
    private float cameraHeight = 10.80f*4;

    Body body;
    GameObject subject;
    public Cameraman(GameObject gameObject){
        this.camera = new OrthographicCamera(gameObject.getBody().getPosition().x,gameObject.getBody().getPosition().y);
        this.camera.setToOrtho(false, cameraWidth,cameraHeight);

        this.subject = gameObject;
        this.camera.viewportWidth = cameraWidth;
        this.camera.viewportHeight = cameraHeight;
        camera.update();
    }
    @Override
    public void render() {

    }
    public OrthographicCamera getShot(){
        System.out.println("updat "+subject.getBody().getPosition().y);
        camera.position.set(subject.getBody().getPosition().x ,camera.position.y,camera.position.z) ;
        camera.update();

        return camera;
    }

    @Override
    public void dispose() {

    }

    @Override
    public Body getBody() {
        return this.body;
    }
}
