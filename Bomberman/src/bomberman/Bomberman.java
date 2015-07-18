/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Jirka
 */
public class Bomberman extends Application {
    private final Drawing drw = new Drawing();
    private final Map map = new Map();
    private final Player p = new Player();
    
    @Override
    public void start(Stage primaryStage) {
        
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 725, 725);
        
        Canvas canvas = new Canvas(scene.getWidth(), scene.getHeight());
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        canvas.widthProperty().bind(scene.widthProperty());
        canvas.heightProperty().bind(scene.heightProperty());
        
        map.newGame();
        drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
        
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent e) -> {
            switch (e.getCode()) {
                case W:
                    p.moveUp();
                    drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                    break;
                case S:
                    p.moveDown();
                    drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                    break;
                case A:
                    p.moveLeft();
                    //System.out.println(map.getPosition().getX() + " - " + map.getPosition().getY());
                    drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                    break;
                case D:
                    p.moveRight();
                    drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                    break;
                    
                case SPACE:
                    p.putBomb();
                    drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                    break;
                    
                case F5:
                    map.newGame();
                    drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                    break;
                    
                case ESCAPE:
                    primaryStage.close();
                    break;
                default:
                    break;
            }
        });
        
        root.getChildren().add(canvas);
        primaryStage.setTitle("Bomberman");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
