package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.awt.*;

public class GameController  {

    private GameInit gameInit = GameInit.getInstance();
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static double windowWidth = screenSize.getWidth();
    private static double windowHeight = screenSize.getHeight();
    //TODO implementing a timer for my program
    //private static Timer timer;
    private static Cell[][] map;
    private static int mapRows;
    private static int mapCols;
    public static GridPane gridPane;
    public static GraphicsContext graphicsContext;
    private double scrollHvalue;
    private double scrollVvalue;
    private Player player = Player.getInstance();

    @FXML
    private Label timerLabel;

    @FXML
    private Label score;

    @FXML
    private Label currentStage;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private HBox infoBar;

    @FXML
    private AnchorPane gameLayout;

    @FXML
    private Canvas canvas;

    @FXML
    void initialize() {
        //timer
        gridPane = new GridPane();
        gameInit.setGridPane(gridPane);
        //gameInit.attach(timer);

        update();
        map = gameInit.getMap();
        mapRows = map.length;
        mapCols = map[0].length;

        infoBar.setPrefHeight(windowHeight*0.1);
        gameLayout.setPrefHeight(mapCols*70+20);
        gameLayout.setPrefWidth(mapRows*70+20);

        scrollHvalue = 70 / (mapCols * 70 - windowWidth);
        scrollVvalue = 70 / (mapRows * 70 - windowHeight);
        initBoomber();

        gameLayout.getChildren().add(0,gridPane);
        player.setPlayerImage(Controller.playerImage);
        player.draw(ConstantsThings.PlayerDirection.RIGHT,1,0);
        gameLayout.getChildren().add(player.getPlayerImageView());


        canvas.setWidth(mapRows*70);
        canvas.setHeight(mapCols*70);
        canvas.setStyle("-fx-background-color:rgba(134,5,0,0.5)");
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.RED);
        graphicsContext.setLineWidth(3);
        graphicsContext.setStroke(Color.ORANGE);
        scrollPane.requestFocus();

    }

    public static void initBoomber(){
        for (int i=0; i<mapRows; i++){
            gridPane.addColumn(i);
            for (int j=0; j<mapCols; j++){
                map[j][i].draw(gridPane,i,j);
            }
        }
    }

    @FXML
    void onMenuClick(){
       GameInit.togglePaused();
       Controller.gameStage.hide();
       Main.menu.show();
    }

    public void update(){
        //TODO adding time to my program
        timerLabel.setText("Time : ");
        //TODO calculating score for the player
        score.setText("Score : ");
        //TODO showing which stage we are for next phase od project
        currentStage.setText("Stage : ");

    }

    //TODO drawing bomb explosions
    public static void drawExplosion(int row,int col){
        graphicsContext.drawImage(new Image("pics/explosion.png"),col*71,row*71);
    }

    public static void clearCanvas(){
      graphicsContext.clearRect(0,0,mapRows*70,mapCols*70);
    }



}
