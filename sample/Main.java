package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    public static Stage menu;

    @Override
    public void start(Stage primaryStage) throws Exception{
        menu = primaryStage;
        Font.loadFont(Main.class.getResource("SNAP ITC.TTF").toExternalForm(), 60);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Boomber Man");
        String css = this.getClass().getResource("menu_styles.css").toExternalForm();
        root.getStylesheets().add(css);
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
