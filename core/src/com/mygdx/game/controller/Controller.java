package com.mygdx.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;

import static com.sun.tools.doclint.Entity.or;

public class Controller {

    private boolean useHardwareKeyboard;
    private boolean useMultiTouch;

    public Controller() {
        useHardwareKeyboard = Gdx.input.isPeripheralAvailable(Input.Peripheral.HardwareKeyboard);
        useMultiTouch = Gdx.input.isPeripheralAvailable(Input.Peripheral.MultitouchScreen);
    }

    private float verticalMotion = 0.0f;
    private float horizontalMotion = 0.0f;

    public Vector3 generateMotionVector() {
        if (useHardwareKeyboard == true) {
            if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)){
                verticalMotion = 1.0f;
            }
            else if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                horizontalMotion = -1.0f;
            }
            else if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                horizontalMotion = 1.0f;
            }
            else if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                verticalMotion = -1.0f;
            }
        }
        return new Vector3(horizontalMotion, verticalMotion, 0);
    }


    private Vector3 vector = new Vector3();

    private int lastXCursorPosition = 0;
    private int lastYCursorPosition = 0;

    public Vector3 generateMousePositionVector() {
        if (Gdx.input.justTouched()) {
            vector.x = lastXCursorPosition = Gdx.input.getX();
            vector.y = lastYCursorPosition = Gdx.input.getY();
        }
        else {
            vector.x = lastXCursorPosition;
            vector.y = lastYCursorPosition;
        }
        return vector;
    }

}
