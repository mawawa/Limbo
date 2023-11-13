package com.nano.nolight.world1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.nano.nolight.interfaces.GameObject;
import com.nano.nolight.world1.player.PlayerOne;

import java.util.ArrayList;
import java.util.List;

public class WorldOne extends ApplicationAdapter implements GameObject {

    private Box2DDebugRenderer debugRenderer;
    //Define the variable in world one.
    private OrthographicCamera orthographicCamera;
    private World world;
    private List<GameObject> worldOneObjects;


    @Override
    public void create(){
        //create a world with gravity 10
        this.world = new World(new Vector2(0, -10), true);
        //create the debugger.
        this.debugRenderer = new Box2DDebugRenderer();
        //create an orthographic camera
        this.orthographicCamera = new OrthographicCamera(1920, 1080);

        //Add the objects for world 1.
        worldOneObjects = new ArrayList<>();
        worldOneObjects.add(new PlayerOne());

    }

    @Override
    public void render() {
        //clear the scene frame
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //populate scene frame
        for(GameObject g: worldOneObjects){
            g.render();
        }
        world.step(1/60f, 6, 2);
        debugRenderer.render(world,orthographicCamera.combined);
    }

    @Override
    public void dispose() {
        for(GameObject g: worldOneObjects){
            g.dispose();
        }

    }
}
