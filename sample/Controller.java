package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Controller {

    @FXML
    private Pane mainPane;

    @FXML
    private HBox mainHbox;

    @FXML
    private VBox menuVbox;

    @FXML
    private VBox settingsVbox;

    @FXML
    private Button imgPrev;

    @FXML
    private Button imgNext;

    @FXML
    private ImageView playersImageview;

    @FXML
    private Button continueBtn;

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double windowWidth = screenSize.getWidth();
    private double windowHeight = screenSize.getHeight();
    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer1;
    public static String playerImage = "Efis";
    public static Stage gameStage;
    private static Button ourContinueBtn;
    public static Stage primaryStage;
    @FXML
    private Label label;
    private LinkedList<String> images = new LinkedList<>();
    private LinkedList<String> faceImages = new LinkedList<>();
    private int imageIndex;



    @FXML
    void initialize() {
        mainHbox.getChildren().remove(settingsVbox);

        mainPane.setPrefSize(windowWidth, windowHeight);
        mainHbox.setPrefSize(windowWidth, windowHeight);
        menuVbox.setPrefSize(windowWidth, windowHeight);

        ourContinueBtn = continueBtn;

        String bip = "src/musics/my4.mp3";
        Media hit = new Media(new File(bip).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

        initImages();

    }

    private void initImages(){

        images.add("Efis");
        images.add("Chara");
        images.add("Brune");
        images.add("Fira");
        images.add("Ufrik");
        images.add("Acri");
        images.add("Clerine");
        images.add("Kienor");

        faceImages.add("EfisFace");
        faceImages.add("CharaFace");
        faceImages.add("BruneFace");
        faceImages.add("FiaraFace");
        faceImages.add("UfrikFace");
        faceImages.add("AcriFace");
        faceImages.add("ClerineFace");
        faceImages.add("KienorFace");

        playersImageview.setImage(PlayerMaker.setImage("EfisFace"));
//        playersImageview.setStyle("-fx-border-style: solid");
//        playersImageview.setStyle("-fx-border-radius: 5; -fx-padding: 10; -fx-background-color: firebrick; -fx-background-radius: 5;" +
//                "-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.8), 10, 0, 0, 0); ");
//

        label.setText(images.get(0));
        label.setFont(new Font("Comic Sans MS",18));
        label.setTextFill(Color.CHOCOLATE);
        label.setPadding(new Insets(5,0,0,0));

    }

    @FXML
    void onContinueGame() {

    }

    @FXML
    void onStartNewGame() throws IOException{
        gameStage = new Stage();
        gameStage.setTitle("Boomber man");
        /*GameEngine.getInstance(diff, mode, 10, 10);
        Player.getInstance().addObserver(GameEngine.getInstance());
*/
        Parent root = FXMLLoader.load(getClass().getResource("game_layout.fxml"));
        String css = this.getClass().getResource("game_styles.css").toExternalForm();
        root.getStylesheets().add(css);
        gameStage.setScene(new Scene(root));
        gameStage.setResizable(false);
        gameStage.setMaximized(true);
        gameStage.initStyle(StageStyle.UNDECORATED);

        mediaPlayer.stop();
        String bip1 = "src/musics/VivaLaVida.mp3";
        Media hit1 = new Media(new File(bip1).toURI().toString());
        mediaPlayer1 = new MediaPlayer(hit1);
        mediaPlayer1.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer1.play();

        //GameEngine.addKeyListeners(root.getScene());

        ourContinueBtn.setDisable(false);
        gameStage.show();
        Main.menu.hide();



    }

    @FXML
    void onHighScore(){

    }

    @FXML
    void onSettingsClick(){
        mainHbox.getChildren().remove(menuVbox);
        mainHbox.getChildren().add(settingsVbox);
    }

    @FXML
    void onSaveClick(){

    }

    @FXML
    void onLoadClick(){

    }

    @FXML
    void onExitClick() {
        Main.menu.close();
    }



    @FXML
    private void onButtonsHover(MouseEvent e) {
        Button button = (Button) e.getSource();
        double width = button.getPrefWidth();
        double height = button.getPrefHeight();

        button.setPrefWidth(width + 20);
        button.setPrefHeight(height + 7);

    }


    @FXML
    void onButtonsLeave(MouseEvent e) {
        Button button = (Button) e.getSource();
        double width = button.getPrefWidth();
        double height = button.getPrefHeight();

        button.setPrefWidth(width - 20);
        button.setPrefHeight(height - 7);
    }


    @FXML
    void onApplyClick() {
        mainHbox.getChildren().remove(settingsVbox);
        mainHbox.getChildren().add(menuVbox);
        playerImage = images.get(imageIndex);
    }

    @FXML
    void onReturnClick() {
        mainHbox.getChildren().remove(settingsVbox);
        mainHbox.getChildren().add(menuVbox);
    }

    @FXML
    void onPrevClick() {
        if (imageIndex >= 1) {
            imageIndex--;
            playersImageview.setImage(PlayerMaker.setImage(faceImages.get(imageIndex)));
            label.setText(images.get(imageIndex));
        }
    }

    @FXML
    void onNextClick() {
        if (imageIndex < images.size() - 1) {
            imageIndex++;
            playersImageview.setImage(PlayerMaker.setImage(faceImages.get(imageIndex)));
            label.setText(images.get(imageIndex));
        }
    }



}
