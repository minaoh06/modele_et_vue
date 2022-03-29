package vue;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class VueApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        File css = new File("css" + File.separator + "style.css");
        
        VBoxCalendrier root = new VBoxCalendrier();
        root.setId("root");
        VBox.setMargin(root, new Insets(20));


        Scene scene = new Scene(root, 290, 300);
        scene.getStylesheets().add(css.toURI().toString());
        stage.setScene(scene);
        stage.show();
        stage.setTitle("hello World");
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}