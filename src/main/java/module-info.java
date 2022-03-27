module com.example.modele_et_vue {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.modele_et_vue to javafx.fxml;
    exports com.example.modele_et_vue;
    exports modele;
    exports vue;
}