package com.example.model;
import com.example.view.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Mino {
    private int max_mino_x = Scene.field_width;
    private int x = 0; //支点x軸
    private int y = 0; //支点y軸
    private int angle = 0; // 0,1,2,3 0,45,90,270
    private int[][][] mino_type; // 0 ~ 6 ７種類
    private List<Integer> mino = new ArrayList<>();

    private int[][][] mino_I = {
        {{1,1,1,1},{0,0,0,0},{0,0,0,0},{0,0,0,0}},
        {{0,1,0,0},{0,1,0,0},{0,1,0,0},{0,1,0,0}},
        {{0,0,0,0},{0,0,0,0},{0,0,0,0},{1,1,1,1}},
        {{0,0,1,0},{0,0,1,0},{0,0,1,0},{0,0,1,0}}
    };

    private int[][][] mino_L = {
        {{0,0,0,1},{0,1,1,1},{0,0,0,0},{0,0,0,0}},
        {{0,1,0,0},{0,1,0,0},{0,1,1,0},{0,0,0,0}},
        {{0,0,0,0},{0,0,0,0},{0,0,1,0},{1,1,1,0}},
        {{0,0,0,0},{0,1,1,0},{0,0,1,0},{0,0,1,0}}
    };

    private int[][][] mino_J = {
        {{0,1,1,1},{0,0,0,1},{0,0,0,0},{0,0,0,0}},
        {{0,1,0,0},{0,1,0,0},{1,1,0,0},{0,0,0,0}},
        {{0,0,0,0},{0,0,0,0},{1,0,0,0},{1,1,1,0}},
        {{0,0,0,0},{0,1,1,0},{0,1,0,0},{0,1,0,0}}

    };

    private int[][][] mino_T = {
        {{0,1,1,1},{0,0,1,0},{0,0,0,0},{0,0,0,0}},
        {{0,1,0,0},{0,1,1,0},{0,1,0,0},{0,0,0,0}},
        {{0,0,0,0},{0,0,0,0},{0,1,0,0},{1,1,1,0}},
        {{0,0,0,0},{0,0,1,0},{0,1,1,0},{0,0,1,0}}

    };

    private int[][][] mino_O = {
        {{1,1,0,0},{1,1,0,0},{0,0,0,0},{0,0,0,0}},
        {{0,1,1,0},{0,1,1,0},{0,0,0,0},{0,0,0,0}},
        {{0,0,0,0},{0,0,0,0},{0,0,1,1},{0,0,1,1}},
        {{0,0,0,0},{0,0,0,0},{0,1,1,0},{0,1,1,0}}

    };

    private int[][][] mino_S = {
        {{0,0,1,1},{0,1,1,0},{0,0,0,0},{0,0,0,0}},
        {{0,1,0,0},{0,1,1,0},{0,0,1,0},{0,0,0,0}},
        {{0,0,0,0},{0,1,1,0},{1,1,0,0},{0,0,0,0}},
        {{0,0,0,0},{0,0,0,0},{0,1,1,0},{1,1,0,0}}
    };

    private int[][][] mino_Z = {
        {{0,1,1,0},{0,0,1,1},{0,0,0,0},{0,0,0,0}},
        {{0,0,1,0},{0,1,1,0},{0,1,0,0},{0,0,0,0}},
        {{0,0,0,0},{1,1,0,0},{0,1,1,0},{0,0,0,0}},
        {{0,0,0,0},{0,0,0,0},{0,1,1,0},{0,0,1,1}}
    };

    private void rand_set(){
        Random rand = new Random();
        int num = rand.nextInt(7) + 1;
        switch (num) {
            case 1:
                this.mino_type = this.mino_I;
                break;
            case 2:
                this.mino_type = this.mino_L;
                break;
            case 3:
                this.mino_type = this.mino_J;
                break;
            case 4:
                this.mino_type = this.mino_T;
                break;
            case 5:
                this.mino_type = this.mino_O;
                break;
            case 6:
                this.mino_type = this.mino_S;
                break;
            case 7:
                this.mino_type = this.mino_Z;
                break;
        }
        
    }

    public int[][][] get(){
        //this.mino_type = this.mino_I;
        rand_set();
        return this.mino_type;
    }

/*    
    public void get(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void get(int angle){
        this.angle = angle;
    }
*/
}
