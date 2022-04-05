package vue;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class VueApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        File css = new File("css" + File.separator + "style.css");
        
        VBoxCalendrier root = new VBoxCalendrier();

        Scene scene = new Scene(root, 290, 340);
        scene.getStylesheets().add(css.toURI().toString());
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
        stage.setTitle("hello World");
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}