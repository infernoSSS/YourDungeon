package com.mygdx.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;

public class Controller {

    private boolean useHardwareKeyboard;
    private boolean useMultiTouch;

    public Controller() {
        useHardwareKeyboard = Gdx.input.isPeripheralAvailable(Input.Peripheral.HardwareKeyboard);
        useMultiTouch = Gdx.input.isPeripheralAvailable(Input.Peripheral.MultitouchScreen);
    }

    private float verticalMotion;
    private float horizontalMotion;

    public Vector3 generateMotionVector() {
        verticalMotion = horizontalMotion = 0.0f;
        if (useHardwareKeyboard) {
            if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) {
                verticalMotion += 1.0f;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                horizontalMotion -= 1.0f;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                horizontalMotion += 1.0f;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                verticalMotion -= 1.0f;
            }
        }
        return new Vector3(horizontalMotion, verticalMotion, 0);
    }


    private Vector3 vector = new Vector3();

    private int lastXCursorPosition = 0;
    private int lastYCursorPosition = 0;

    public boolean isTouched() {
        return Gdx.input.isTouched();
    }

    public Vector3 generateMousePositionVector() {
        if (Gdx.input.isTouched()) {
            vector.x = lastXCursorPosition = Gdx.input.getX();
            vector.y = lastYCursorPosition = Gdx.graphics.getHeight() - Gdx.input.getY();
        }
        else {
            vector.x = lastXCursorPosition;
            vector.y = lastYCursorPosition;
        }
        vector.z = 0;
        return vector;
    }

}
