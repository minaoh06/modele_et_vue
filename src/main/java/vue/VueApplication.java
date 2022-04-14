package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class VueApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        File css = new File("css" + File.separator + "style.css");
        
        HBoxRoot root = new HBoxRoot();

        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(css.toURI().toString());
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
        stage.setTitle("Calendrier");
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}