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
    }
    
    private void drawBackGround(GraphicsContext gc, double width, double height){
        gc.setFill(Color.GREY);
        gc.fillRect(0, 0, width, height);
    }
    
    private void drawMap(GraphicsContext gc){
        for(Square s : map.getMap()){
            gc.setFill(Color.BLACK);
            gc.fillRect(s.getCoordinates().getX()*pixel, s.getCoordinates().getY()*pixel, pixel, pixel);
            gc.setFill(s.getColor());
            gc.fillRect(s.getCoordinates().getX()*pixel, s.getCoordinates().getY()*pixel, pixel-1, pixel-1);
            
            
            /*try {
                Thread.sleep(10);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }*/

        }
    }
    
    private void drawPlayer(GraphicsContext gc){
        gc.setFill(Color.AZURE);
        gc.fillOval(14*pixel, 14*pixel, pixel-2, pixel-2);
    }
    
    

    
}
