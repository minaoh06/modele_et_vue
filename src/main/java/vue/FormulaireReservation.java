package vue;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

/*
*   |      0      | 1         | 2  3   x
* 0 | titre       |           |
* 1 | lab cours   | textefild |
* 2 |             |           |
* 3 |
* 4 |
* 5 |
* y
* */

public class FormulaireReservation extends GridPane {
    public FormulaireReservation(){
        setVgap(20);
        setHgap(20);

        //Titre
        Label labTitre = new Label("Titre");
        add(labTitre, 3, 0, 1, 1);
        labTitre.setAlignment(Pos.TOP_CENTER);

        add(new Separator(), 0,1,5,1);

        //Partie cours
        Label cours = new Label("_Cours");
        TextField textFieldCours = new TextField();

        cours.setLabelFor(textFieldCours);
        cours.setMnemonicParsing(true);

        add(cours, 0,2,1,1);
        add(textFieldCours, 1,2,5,1);

        //Partie niveau
        ToggleGroup groupNiveau = new ToggleGroup();
        Label niveau = new Label("_Niveau");
        niveau.setMnemonicParsing(true);
        add(niveau, 0,3,1,1);

        RadioButton debutant = new RadioButton("_Débutant");
        debutant.setMnemonicParsing(true);
        debutant.setToggleGroup(groupNiveau);
        add(debutant, 1,3,2,1);

        RadioButton moyen = new RadioButton("_Moyen");
        moyen.setMnemonicParsing(true);
        moyen.setToggleGroup(groupNiveau);
        add(moyen, 3,3,2,1);

        RadioButton avance = new RadioButton("_Avancé");
        avance.setMnemonicParsing(true);
        avance.setToggleGroup(groupNiveau);
        add(avance, 1,4,2,1);

        RadioButton expert = new RadioButton("_Expert");
        expert.setMnemonicParsing(true);
        expert.setToggleGroup(groupNiveau);
        add(expert, 3,4,2,1);


        //Partie horaire
        Label horaire = new Label("_Horaire");
        horaire.setMnemonicParsing(true);
        add(horaire, 0,5,1,1);

        add(new Label("de"), 1,5,1,1);
        add(new Label("h"), 3,5,1,1);
        add(new Label("h"), 3,6,1,1);

        ComboBox<Integer> heure1 = new ComboBox<Integer>();
        ComboBox<Integer> heure2 = new ComboBox<Integer>();
        for (int i = 0; i < 23; i++)
        {
            heure1.getItems().add(i);
            heure2.getItems().add(i);
        }

        ComboBox<Integer> minute1 = new ComboBox<Integer>();
        ComboBox<Integer> minute2 = new ComboBox<Integer>();
        for (int i = 0; i <= 60; i+=15)
        {
            minute1.getItems().add(i);
            minute2.getItems().add(i);
        }

        add(heure1, 2,5,1,1);
        add(heure2, 2,6,1,1);
        add(minute1, 4,5,1,1);
        add(minute2, 4,6,1,1);

        add(new Separator(), 0,7,5,1);


    }
}
