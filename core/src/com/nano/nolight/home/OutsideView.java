package com.nano.nolight.home;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Body;
import com.nano.nolight.Game;
import com.nano.nolight.interfaces.GameObject;
import com.nano.nolight.world1.Cameraman;

import javax.swing.*;
import java.awt.*;

public class OutsideView implements GameObject {

    private OrthographicCamera camera;
    private int height;
    private int width;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    public  OutsideView() {
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

    public void render(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            Sound enterSound = Gdx.audio.newSound(Gdx.files.internal("assets/home/sounds/enter.mp3"));
            enterSound.play();
            Game.SCENE = new LivingRoom();

        }
        camera.update();
        renderer.setView(camera);
        renderer.render();
    }

    public void dispose(){
        System.out.println("clean");
    }

    public Body getBody() {
        return null;
    }
}
