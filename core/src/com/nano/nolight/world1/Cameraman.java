package com.nano.nolight.world1;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Body;
import com.nano.nolight.interfaces.GameObject;

public class Cameraman implements GameObject {
    private OrthographicCamera camera;
    private float cameraWidth = 19.2f;
    private float cameraHeight = 10.8f;

    Body body;
    GameObject subject;
    public Cameraman(GameObject gameObject){
        this.camera = new OrthographicCamera(gameObject.getBody().getPosition().x,gameObject.getBody().getPosition().y);
        this.subject = gameObject;
        this.camera.viewportWidth = cameraWidth;
        this.camera.viewportHeight = cameraHeight;
        camera.update();
    }
    @Override
    public void render() {
        camera.position.x = subject.getBody().getPosition().x;
        camera.position.y = subject.getBody().getPosition().y;
        camera.update();
    }
    public OrthographicCamera getShot(){
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
