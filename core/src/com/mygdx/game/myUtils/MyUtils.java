package com.mygdx.game.myUtils;

public class MyUtils {
    public static float randomPlusOrMinus(){
        if (Math.random() > 0.5f){
            return 1;
        }else {
            return -1;
        }
    }
}
