/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import javafx.scene.paint.Color;

/**
 *
 * @author Jirka
 */
public class SquarStone extends Square{
    private Color c = Color.GREY;
    
    public SquarStone(MyPoint p){
        coordinates = p;
        color = this.c;
        id = 3;
    }
}