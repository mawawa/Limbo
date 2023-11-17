package com.nano.nolight;

import com.badlogic.gdx.ApplicationAdapter;
import com.nano.nolight.home.OutsideView;
import com.nano.nolight.interfaces.GameObject;

import javax.swing.plaf.SplitPaneUI;

public class Game extends ApplicationAdapter {
    public static GameObject SCENE;

    @Override
    public void create(){
        SCENE = new OutsideView();

    }
    @Override
    public void render(){
        SCENE.render();
    }
    @Override
    public void dispose(){
        SCENE.dispose();
    }
}
