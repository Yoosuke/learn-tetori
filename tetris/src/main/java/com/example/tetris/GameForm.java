package com.example.tetris;

import javax.swing.JFrame;
import javax.swing.InputMap;
import javax.swing.ActionMap;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

public class GameForm extends JFrame {
    private GameArea ga;

    public GameForm ()
    {
        ga = new GameArea(10);
        this.add( ga );

        initControls();

        startGame();
    }

    private void initControls(){
        InputMap im = this.getRootPane().getInputMap();
        ActionMap am = this.getRootPane().getActionMap();

        im.put(KeyStroke.getKeyStroke("RIGHT"), "right");
        im.put(KeyStroke.getKeyStroke("LEFT"), "left");
        im.put(KeyStroke.getKeyStroke("UP"), "up");
        im.put(KeyStroke.getKeyStroke("DOWN"), "down");

        /*
        class MyClass1 extends AbstractAction{};
        class MyClass2 extends AbstractAction{};
        am.put("right", new MyClass1());
        am.put("left", new MyClass2());
        */

        //無名関数に書き直すと以下

        am.put("right", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                ga.moveBlockRight();
            }
        });

        am.put("left", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                ga.moveBlockLeft();
            }
        });

        am.put("up", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                ga.rotateBlock();
            }
        });

        am.put("down", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                ga.dropBlock();
            }
        });

    }


    public void startGame()
    {
        new GameThread(ga).start();
    }

    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameForm().setVisible(true);
            }
        });
    }

}