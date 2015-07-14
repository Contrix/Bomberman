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
    
    @Override
    public void start(Stage primaryStage) {
        
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 700, 700);
        
        Canvas canvas = new Canvas(scene.getWidth(), scene.getHeight());
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        
        canvas.widthProperty().bind(scene.widthProperty());
        canvas.heightProperty().bind(scene.heightProperty());
        
        
        map.newGame();
        drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent e) -> {
            switch (e.getCode()) {
                case W:
                    map.newGame();
                    drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                    break;
                case S:
                    break;
                case A:
                    break;
                case D:
                    break;
                    
                case SPACE:
                    break;
                    
                case F5:
                    map.newGame();
                    drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
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
