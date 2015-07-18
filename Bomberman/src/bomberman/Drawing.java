/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Jirka
 */
public class Drawing {
    private final int pixel = 25;
    private final Map map = new Map();
    
    public void drawAll(GraphicsContext gc, double width, double height){
        drawBackGround(gc, width, height);
        drawMap(gc);
        drawPlayer(gc);
        drawMinimap(gc);
    }
    
    private void drawBackGround(GraphicsContext gc, double width, double height){
        gc.setFill(Color.GREY);
        gc.fillRect(0, 0, width, height);
    }
    
    private void drawMap(GraphicsContext gc){
        for(Square s : map.getMap()){
            gc.setFill(Color.BLACK);
            gc.fillRect((s.getCoordinates().getX()+14-map.getPosition().getX())*pixel, (s.getCoordinates().getY()+14-map.getPosition().getY())*pixel , pixel, pixel);
            if(s.getID() == 2){
                drawSquareBrick(gc, new MyPoint(s.getCoordinates().getX()+14-map.getPosition().getX(), s.getCoordinates().getY()+14-map.getPosition().getY()));
            }
            else{
                gc.setFill(s.getColor());
                gc.fillRect((s.getCoordinates().getX()+14-map.getPosition().getX())*pixel, (s.getCoordinates().getY()+14-map.getPosition().getY())*pixel , pixel-1, pixel-1);
            }
            /*try {
                Thread.sleep(10);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }*/
        }
    }
    
    private void drawPlayer(GraphicsContext gc){
        gc.setFill(Color.CHOCOLATE);
        gc.fillOval(14*pixel, 14*pixel, pixel-2, pixel-2);
    }
    
    private void drawMinimap(GraphicsContext gc){
        gc.setFill(Color.WHITE);
        gc.fillRect(600, 600, 100, 100);
        map.getWorld().stream().forEach((s) -> {
            gc.setFill(s.getColor());
            gc.fillRect(600 + s.getCoordinates().getX(), 600 + s.getCoordinates().getY(), 1, 1);
        });
        gc.setFill(Color.RED);
        gc.fillRect(600 + map.getPosition().getX()-2, 600 + map.getPosition().getY() -2, 5, 5);
    }
    
    private void drawSquareBrick(GraphicsContext gc, MyPoint p){
        gc.setFill(Color.BISQUE);
        gc.fillRect(pixel*p.getX(), pixel*p.getY(), pixel, pixel);
        gc.setFill(Color.DARKGREY);
        
        gc.strokeLine(pixel*p.getX(), pixel*p.getY() + pixel/3, pixel*(p.getX()+1) - 1, pixel*(p.getY()) + pixel/3);
        gc.strokeLine(pixel*p.getX(), pixel*p.getY() + pixel/3*2, pixel*(p.getX()+1) - 1, pixel*(p.getY()) + pixel/3*2);
        gc.strokeLine(pixel*p.getX(), pixel*p.getY(), pixel*(p.getX()+1) - 1, pixel*(p.getY()));
        
        gc.strokeLine(pixel*p.getX() + pixel/3, pixel*p.getY() + pixel/3, pixel*p.getX() + pixel/3, pixel*p.getY() + pixel/3*2);
        gc.strokeLine(pixel*p.getX() + pixel/3*2, pixel*p.getY() + pixel/3*2, pixel*p.getX() + pixel/3*2, pixel*p.getY() + pixel-1);
        gc.strokeLine(pixel*p.getX() + pixel/3, pixel*p.getY() + pixel/3, pixel*p.getX() + pixel/3, pixel*p.getY() + pixel/3*2);
        gc.strokeLine(pixel*p.getX(), pixel*p.getY(), pixel*p.getX(), pixel*p.getY() + pixel/3-1);
    }
}
