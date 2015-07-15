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
    private static MyPoint position = new MyPoint(50,50);
    private int range = 10;
    private static ArrayList<Square> squares = new ArrayList<>();
    private static ArrayList<Square> world = new ArrayList<>();
    private  ArrayList<Square> outRange = new ArrayList<>();
    private Square neighbour;
    
    
    public void newGame(){
        position = new MyPoint(50,50);
        squares.clear();
        squares.add(new SquareGrass(new MyPoint(position.getX(), position.getY())));
        for (int i = 1; i <= range; i++){
            for (int j = 0; j <= i*2; j++){
                squares.add(newSquare(new MyPoint(position.getX() - i + j, position.getY() - i)));
                squares.add(newSquare(new MyPoint(position.getX() + i, position.getY() -i + j)));
                squares.add(newSquare(new MyPoint(position.getX() + i - j, position.getY() + i)));
                squares.add(newSquare(new MyPoint(position.getX() - i, position.getY() + i - j)));
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
        checkNeighbours(squares);
        world = squares;
    }
    
    private void checkNeighbours(ArrayList<Square> sq){
        for(Square s: sq){
            for(Square p: squares){
                if(p.getCoordinates().getY() - 1 == s.getCoordinates().getY()){
                    s.setLeftNeighbour(p);
                }
                else if(p.getCoordinates().getY() + 1 == s.getCoordinates().getY()){
                    s.setRightNeighbour(p);
                }
                else if(p.getCoordinates().getX() - 1 == s.getCoordinates().getX()){
                    s.setUpperNeighbour(p);
                }
                else if(p.getCoordinates().getX() + 1 == s.getCoordinates().getX()){
                    s.setLowerNeighbour(p);
                }
            }
        }
    }
    
    private Square newSquare(MyPoint p){
        switch(random.nextInt(10)){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return(new SquareGrass(p));
            case 6:
            case 7:
                return(new SquareBrick(p));
            case 8:
            case 9:
                return(new SquareWall(p));
            default:
                break;
        }
        return(null);
    }
    
    public ArrayList<Square> getMap(){
        return (squares);
    }
    
    public void moveLeft()
    {
        for (Square s : squares){
            if (position.getX() - s.getCoordinates().getX() > range){
                outRange.add(s);
            }
            //else if (s.getCoordinates().getX() - position.getX() == range-1){
                //System.out.println("ddddd");
                /*if(s.getLeftNeighbour()!= null){
                    squares.add(s.getLeftNeighbour());
                }*/
                //System.out.println(s.getRightNeighbour() + " - " + s.getCoordinates().getX() + " - " + s.getCoordinates().getY());
                /*else{
                    neighbour = newSquare(position);
                    s.setLeftNeighbour(neighbour);
                    neighbour.setRightNeighbour(s);
                    world.add(neighbour);
                    squares.add(neighbour);
                }*/
            //}
        }
        squares.removeAll(outRange);
        outRange.clear();
    }
    
    public void moveRight()
    {
        for (Square s : squares){
            if (s.getCoordinates().getX() - position.getX() > range){
                outRange.add(s);
            }
        }
        squares.removeAll(outRange);
        outRange.clear();
    }
    
    public void moveUp()
    {
        {
        for (Square s : squares){
            if (position.getY() - s.getCoordinates().getY()> range){
                outRange.add(s);
            }
        }
        squares.removeAll(outRange);
        outRange.clear();
    }
    }
    
    public void moveDown()
    {
        {
        for (Square s : squares){
            if (s.getCoordinates().getY() - position.getY() > range){
                outRange.add(s);
            }
        }
        squares.removeAll(outRange);
        outRange.clear();
    }
    }
    
    public MyPoint getPosition(){
        return (position);
    }
    public void setPosition(MyPoint p){
        position = p;
    }
    
}
