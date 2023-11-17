package com.nano.nolight.home;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Body;
import com.nano.nolight.interfaces.GameObject;
import com.nano.nolight.world1.Cameraman;

import javax.swing.*;
import java.awt.*;

public class OutsideView extends ApplicationAdapter  {

    private OrthographicCamera camera;
    private int height;
    private int width;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    @Override
    public void create() {
        this.camera = new OrthographicCamera();
        this.width = 1920;
        this.height = 1080;
        camera.setToOrtho(false, width, height);
        Sound sound = Gdx.audio.newSound(Gdx.files.internal("assets/home/sounds/backsound.mp3"));
        sound.play(0.5f);
        Gdx.graphics.setSystemCursor(Cursor.SystemCursor.None);
        map = new TmxMapLoader().load("assets/home/Tiled/view.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
    }

    @Override
    public void render(){
        camera.update();
        renderer.setView(camera);
        renderer.render();
    }

    @Override
    public void dispose(){
        System.out.println("clean");
    }
}
