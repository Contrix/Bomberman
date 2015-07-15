/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

/**
 *
 * @author Jirka
 */
public class Player {
    private final Map map = new Map();
    
    public void moveLeft(){
        if(entry(0)){
            map.setPosition(new MyPoint(map.getPosition().getX()-1, map.getPosition().getY()));
            map.moveRight();
        }
    }
    
    public void moveRight(){
        if(entry(1)){
            map.setPosition(new MyPoint(map.getPosition().getX()+1, map.getPosition().getY()));
            map.moveLeft();
        }
    }
    
    public void moveUp(){
        if(entry(2)){
            map.setPosition(new MyPoint(map.getPosition().getX(), map.getPosition().getY()-1));
            map.moveDown();
        }
    }
    
    public void moveDown(){
        if(entry(3)){
            map.setPosition(new MyPoint(map.getPosition().getX(), map.getPosition().getY()+1));
            map.moveUp();
        }
    }    
    
    private boolean entry (int i){
        for (Square s : map.getMap()){
            if(s.entry()){
                switch (i){
                    case 0:
                        if(s.getCoordinates().getX() == map.getPosition().getX() - 1 && s.getCoordinates().getY() == map.getPosition().getY()){
                            return true;
                        }
                        break;
                    case 1:
                        if(s.getCoordinates().getX() == map.getPosition().getX() + 1 && s.getCoordinates().getY() == map.getPosition().getY()){
                            return true;
                        }
                        break;
                    case 2:
                        if(s.getCoordinates().getY() == map.getPosition().getY() - 1 && s.getCoordinates().getX() == map.getPosition().getX()){
                            return true;
                        }
                        break;
                    case 3:
                        if(s.getCoordinates().getY() == map.getPosition().getY() + 1 && s.getCoordinates().getX() == map.getPosition().getX()){
                            return true;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return false;
    }
    
    public void bomb(){
        
    }
}
