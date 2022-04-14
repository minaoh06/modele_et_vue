package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import modele.DateCalendrier;

public class FormulaireReservation extends GridPane {

    public Label titre;

    TextField textFieldCours;

    public ComboBox<Integer> heure1;
    public ComboBox<Integer> heure2;

    public ComboBox<Integer> minute1;
    public ComboBox<Integer> minute2;


    public FormulaireReservation(){
        setVgap(20);
        setHgap(5);

        //Titre
        DateCalendrier today = new DateCalendrier();
        titre = new Label(""+today.toString());
        titre.setUserData(today);
        add(titre, 3, 0, 1, 1);
        titre.setAlignment(Pos.TOP_CENTER);

        add(new Separator(), 0,1,5,1);

        //Partie cours
        Label cours = new Label("_Cours");
        textFieldCours = new TextField();

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
        debutant.setSelected(true);
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

        heure1 = new ComboBox<Integer>();
        heure2 = new ComboBox<Integer>();
        for (int i = 0; i < 23; i++)
        {
            heure1.getItems().add(i);
            heure2.getItems().add(i);
        }
        heure1.getSelectionModel().select(7);
        heure2.getSelectionModel().select(8);

        minute1 = new ComboBox<Integer>();
        minute2 = new ComboBox<Integer>();
        for (int i = 0; i <= 60; i+=15)
        {
            minute1.getItems().add(i);
            minute2.getItems().add(i);
        }
        minute1.getSelectionModel().select(0);
        minute2.getSelectionModel().select(0);

        add(heure1, 2,5,1,1);
        add(heure2, 2,6,1,1);
        add(minute1, 4,5,1,1);
        add(minute2, 4,6,1,1);

        add(new Separator(), 0,7,5,1);

        Button annuler = new Button("Annuler");
        add(annuler, 3,8,1,1);
        Button save = new Button("Enregistrer");
        add(save, 4,8,1,1);

        //Event
        annuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                textFieldCours.setText("");
                debutant.setSelected(true);
                heure1.getSelectionModel().select(7);
                heure2.getSelectionModel().select(8);
                minute1.getSelectionModel().select(0);
                minute2.getSelectionModel().select(0);
            }
        });
    }

    public Label getTitre()
    {
        return titre;
    }

    public TextField getTextFieldCours()
    {
        return textFieldCours;
    }

    public ComboBox<Integer> getHeure1()
    {
        return heure1;
    }

    public ComboBox<Integer> getHeure2()
    {
        return heure2;
    }
    public ComboBox<Integer> getMinute1()
    {
        return minute1;
    }
    public ComboBox<Integer> getMinute2()
    {
        return minute2;
    }

}
