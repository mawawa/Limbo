package com.nano.nolight.home;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Body;
import com.nano.nolight.interfaces.GameObject;

public class LivingRoom implements GameObject {
    private final OrthographicCamera camera;
    private final int height;
    private final int width;
    OrthogonalTiledMapRenderer mapRenderer;
    TiledMap map;

    public LivingRoom(){
        this.width = 1920;
        this.height = 1080;
        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);
        map = new TmxMapLoader().load( "assets/home/Tiled/livingroom.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map);

    }

    @Override
    public void render() {
        camera.update();
        mapRenderer.setView(camera);
        mapRenderer.render();
    }

    @Override
    public void dispose() {

    }

    @Override
    public Body getBody() {
        return null;
    }
}
