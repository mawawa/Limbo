package com.nano.nolight.world1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.nano.nolight.interfaces.GameObject;
import com.nano.nolight.world1.ground.Ground;
import com.nano.nolight.world1.player.PlayerOne;

import java.util.ArrayList;
import java.util.List;

public class WorldOne extends ApplicationAdapter implements GameObject {
    Body body;
    private Box2DDebugRenderer debugRenderer;
    //Define the variable in world one.
    private OrthographicCamera orthographicCamera;
    private World world;
    private List<GameObject> worldOneObjects;
    private Cameraman cameraman;
    private PlayerOne player1;


    @Override
    public void create(){
        //create a world with gravity 10
        this.world = new World(new Vector2(0, -10), true);
        //create the debugger.
        this.debugRenderer = new Box2DDebugRenderer();

        //create a new cameramen


        //Add the objects for world 1.

        worldOneObjects = new ArrayList<>();
        worldOneObjects.add(new Ground(world));
        this.player1 = new PlayerOne(world);
        worldOneObjects.add(player1);
        this.cameraman = new Cameraman(player1);
        worldOneObjects.add(new Cameraman(player1));

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
        debugRenderer.render(world,cameraman.getShot().combined);
    }

    @Override
    public void dispose() {
        for(GameObject g: worldOneObjects){
            g.dispose();
        }

    }

    @Override
    public Body getBody() {
        return this.body;
    }
}
