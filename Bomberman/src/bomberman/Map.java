/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jirka
 */
public class Map {
    Random random = new Random();
    private MyPoint position = new MyPoint(14,14);
    private int range = 12;
    private static ArrayList<Square> squares = new ArrayList<>();
    private static ArrayList<Square> world = new ArrayList<>();
    
    
    public void newGame(){
        squares.clear();
        squares.add(new SquareGrass(new MyPoint(position.getX(), position.getY())));
        for (int i = 1; i <= range; i++){
            for (int j = 0; j <= i*2; j++){
                newSquare(new MyPoint(position.getX() - i + j, position.getY() - i));
                newSquare(new MyPoint(position.getX() + i, position.getY() -i + j));
                newSquare(new MyPoint(position.getX() + i - j, position.getY() + i));
                newSquare(new MyPoint(position.getX() - i, position.getY() + i - j));
            }
            /*for (int j = 0; j <= i*2; j++){
                newSquare(new MyPoint(position.getX() + i, position.getY() -i + j));
            }
            for (int j = 0; j <= i*2; j++){
                newSquare(new MyPoint(position.getX() + i - j, position.getY() + i));
            }
            for (int j = 0; j <= i*2; j++){
                newSquare(new MyPoint(position.getX() - i, position.getY() + i - j));
            }*/
        }
        world = squares;
    }
    
    private void newSquare(MyPoint p){
        switch(random.nextInt(10)){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                squares.add(new SquareGrass(p));
                break;
            case 6:
            case 7:
                squares.add(new SquareBrick(p));
                break;
            case 8:
            case 9:
                squares.add(new SquareWall(p));
                break;
            default:
                break;
        }
        //squares.add(new SquareBrick(p));
    }
    
    public ArrayList<Square> getMap(){
        return (squares);
    }
    
    public void moveLeft()
    {
        for (Square s : squares){
            if (s.getCoordinates().getX()>position.getX()+range){
                //squares.
            }
        }
    }
    
    public void moveRight()
    {
        
    }
    
    public void moveUp()
    {
        
    }
    
    public void moveDown()
    {
        
    }
    
}
