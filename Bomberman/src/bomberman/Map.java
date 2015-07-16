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
    private static MyPoint position;
    private int range = 10;
    private static ArrayList<Square> squares = new ArrayList<>();
    private static ArrayList<Square> world = new ArrayList<>();
    private static ArrayList<Square> incomplete = new ArrayList<>();
    private ArrayList<Square> outRange = new ArrayList<>();
    private ArrayList<Square> newSquares = new ArrayList<>();
    private ArrayList<Square> remove = new ArrayList<>();
    private Square tmp;
    
    public void newGame(){
        position = new MyPoint(50, 50);
        squares.clear();
        world.clear();
        incomplete.clear();
        //squares.add(new SquareGrass(new MyPoint(position.getX(), position.getY())));
        /*for (int i = 1; i <= range; i++){
            for (int j = 0; j <= i*2; j++){
                squares.add(newSquare(new MyPoint(position.getX() - i + j, position.getY() - i)));
                squares.add(newSquare(new MyPoint(position.getX() + i, position.getY() -i + j)));
                squares.add(newSquare(new MyPoint(position.getX() + i - j, position.getY() + i)));
                squares.add(newSquare(new MyPoint(position.getX() - i, position.getY() + i - j)));
            }*/
            /*for (int j = 0; j <= i*2; j++){
                newSquare(new MyPoint(position.getX() + i, position.getY() -i + j));
            }
            for (int j = 0; j <= i*2; j++){
                newSquare(new MyPoint(position.getX() + i - j, position.getY() + i));
            }
            for (int j = 0; j <= i*2; j++){
                newSquare(new MyPoint(position.getX() - i, position.getY() + i - j));
            }*/
        //}
        for (int i = 0; i <= range*2; i++){
            for (int j = 0; j <= range*2; j++){
                if(position.getX() == i  && position.getY() == j){
                    squares.add(new SquareGrass(new MyPoint(position.getX(), position.getY())));
                }
                else{
                    squares.add(newSquare(new MyPoint(position.getX() + i-range, position.getY()+ j-range)));
                }
            }
        }
        checkNeighbours(squares);
    }
    
    private void checkNeighbours(ArrayList<Square> sq){
        for(Square s: sq){
            for(Square p: incomplete){
                if(p.getCoordinates().getY() - 1 == s.getCoordinates().getY() && p.getCoordinates().getX() == s.getCoordinates().getX()){
                    s.setLowerNeighbour(p);
                    p.setUpperNeighbour(s);
                }
                else if(p.getCoordinates().getY() + 1 == s.getCoordinates().getY() && p.getCoordinates().getX() == s.getCoordinates().getX()){
                    s.setUpperNeighbour(p);
                    p.setLowerNeighbour(s);
                }
                else if(p.getCoordinates().getX() - 1 == s.getCoordinates().getX() && p.getCoordinates().getY() == s.getCoordinates().getY()){
                    s.setRightNeighbour(p);
                    p.setLeftNeighbour(s);
                }
                else if(p.getCoordinates().getX() + 1 == s.getCoordinates().getX() && p.getCoordinates().getY() == s.getCoordinates().getY()){
                    s.setLeftNeighbour(p);
                    p.setRightNeighbour(s);
                }
            }
            if (s.getLeftNeighbour() != null && s.getRightNeighbour() != null  && s.getUpperNeighbour() != null && s.getLowerNeighbour() != null){
                incomplete.remove(s);
            }
            incomplete.stream().forEach((p) ->{
                if (p.getLeftNeighbour() != null && p.getRightNeighbour() != null  && p.getUpperNeighbour() != null && p.getLowerNeighbour() != null){
                    remove.add(p);
                }
            }); 
        }
        incomplete.removeAll(remove);
        remove.clear();
    }
    
    private Square newSquare(MyPoint p){
        switch(random.nextInt(10)){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                tmp = new SquareGrass(p);
                break;
            case 6:
            case 7:
                tmp = new SquareBrick(p);
                break;
            case 8:
            case 9:
                tmp = new SquareWall(p);
                break;
            default:
                break;
        }
        incomplete.add(tmp);
        world.add(tmp);
        return(tmp);
    }
    
    public ArrayList<Square> getMap(){
        return (squares);
    }
    
    public void moveLeft(){
        for (Square s : squares){
            if (position.getX() - s.getCoordinates().getX() > range){
                outRange.add(s);
            }
            else if (s.getCoordinates().getX() - position.getX() == range-1){
                if(s.getRightNeighbour()!= null){
                    newSquares.add(s.getRightNeighbour());
                }
                else{
                    newSquares.add(newSquare(new MyPoint(s.getCoordinates().getX()+1, s.getCoordinates().getY())));
                }
            }
        }
        squares.removeAll(outRange);
        outRange.clear();
        checkNeighbours(newSquares);
        squares.addAll(newSquares);
        newSquares.clear();
    }
    
    public void moveRight(){
        for (Square s : squares){
            if (s.getCoordinates().getX() - position.getX() > range){
                outRange.add(s);
            }
            else if (position.getX() - s.getCoordinates().getX() == range - 1){
                if(s.getLeftNeighbour()!= null){
                    newSquares.add(s.getLeftNeighbour());
                }
                else{
                    newSquares.add(newSquare(new MyPoint(s.getCoordinates().getX() - 1, s.getCoordinates().getY())));
                }
            }
        }
        squares.removeAll(outRange);
        outRange.clear();
        checkNeighbours(newSquares);
        squares.addAll(newSquares);
        newSquares.clear();
    }
    
    public void moveUp(){
        for (Square s : squares){
            if (position.getY() - s.getCoordinates().getY() > range){
                outRange.add(s);
            }
            else if (s.getCoordinates().getY() - position.getY() == range-1){
                if(s.getLowerNeighbour()!= null){
                    newSquares.add(s.getLowerNeighbour());
                }
                else{
                    newSquares.add(newSquare(new MyPoint(s.getCoordinates().getX(), s.getCoordinates().getY()+1)));
                }
            }
        }
        squares.removeAll(outRange);
        outRange.clear();
        checkNeighbours(newSquares);
        squares.addAll(newSquares);
        newSquares.clear();
    }
    
    public void moveDown(){
        for (Square s : squares){
            if (s.getCoordinates().getY() - position.getY() > range){
                outRange.add(s);
            }
            else if (position.getY() - s.getCoordinates().getY() == range - 1){
                if(s.getUpperNeighbour()!= null){
                    newSquares.add(s.getUpperNeighbour());
                }
                else{
                    newSquares.add(newSquare(new MyPoint(s.getCoordinates().getX(), s.getCoordinates().getY() - 1)));
                }
            }
        }
        squares.removeAll(outRange);
        outRange.clear();
        checkNeighbours(newSquares);
        squares.addAll(newSquares);
        newSquares.clear();
    }
    
    public MyPoint getPosition(){
        return (position);
    }
    public void setPosition(MyPoint p){
        position = p;
    }
}
