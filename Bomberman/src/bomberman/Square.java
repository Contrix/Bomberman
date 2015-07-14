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
public class Square {
    protected Color color;
    protected MyPoint coordinates;
    protected Square upperNeighbour;
    protected Square lowerNeighbour;
    protected Square leftNeighbour;
    protected Square rightNeighbour;
    
    public void Square(MyPoint p){
    }
    
    public MyPoint getCoordinates(){
        return(coordinates);
    }
    public Color getColor(){
        return(color);
    }
    
    public void setUpperNeighbour(Square s){
        this.upperNeighbour = s;
    }
    
    public void setLowerNeighbour(Square s){
        this.lowerNeighbour = s;
    }
    
    public void setLeftNeighbour(Square s){
        this.leftNeighbour = s;
    }
    
    public void setRightNeighbour(Square s){
        this.rightNeighbour = s;
    }
    
    public Square getUpperNeighbour(Square s){
        return(upperNeighbour);
    }
    
    public Square getLowerNeighbour(Square s){
        return(lowerNeighbour);
    }
    
    public Square getLeftNeighbour(Square s){
        return(leftNeighbour);
    }
    
    public Square getRightNeighbour(Square s){
        return(rightNeighbour);
    }
    
}
