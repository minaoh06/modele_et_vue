package vue;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class FormulaireReservation extends GridPane {
    public FormulaireReservation(){
        setVgap(20);
        setHgap(20);

        //Partie cours
        Label cours = new Label("_Cours");
        TextField textFieldCours = new TextField();

        cours.setLabelFor(textFieldCours);
        cours.setMnemonicParsing(true);

        add(cours, 0,1,1,1);
        add(textFieldCours, 1,0,3,1);

        //Partie niveau
        Label niveau = new Label("_Niveau");
        add(niveau, 0,2,1,1);

        Label labDeb = new Label("_Débuitant");
        RadioButton debutant = new RadioButton();
        labDeb.setLabelFor(debutant);
        debutant.setMnemonicParsing(true);
        add(debutant, 1,1,1,1);
        add(labDeb, 1,2,1,1);

        Label labMoy = new Label("_Moyen");
        RadioButton moyen = new RadioButton();
        labMoy.setLabelFor(moyen);
        moyen.setMnemonicParsing(true);
        add(moyen, 2,1,1,1);
        add(labMoy, 2,2,1,1);

        RadioButton avance = new RadioButton("_Avancé");
        avance.setMnemonicParsing(true);
        add(avance, 1,2,2,1);

        RadioButton expert = new RadioButton("_Expert");
        expert.setMnemonicParsing(true);
        add(expert, 2,2,2,1);


        //Partie horaire
        add(new Label("_Horaire"), 0,3,1,1);
    }
}
