package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import modele.DateCalendrier;

public class FormulaireReservation extends GridPane {

    private final Label titre;

    private final TextField textFieldCours;

    private final ComboBox<Integer> heure1;
    private final ComboBox<Integer> heure2;

    private final ComboBox<Integer> minute1;
    private final ComboBox<Integer> minute2;

    private final RadioButton debutant;
    private final RadioButton moyen;
    private final RadioButton expert;
    private final RadioButton avance;

    public FormulaireReservation(){
        setVgap(20);
        setHgap(5);

        //Titre
        DateCalendrier today = new DateCalendrier();
        titre = new Label(""+today.toString());
        titre.setUserData(today);
        add(titre, 2, 0, 3, 1);
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

        debutant = new RadioButton("_Débutant");
        debutant.setMnemonicParsing(true);
        debutant.setToggleGroup(groupNiveau);
        debutant.setAccessibleText("Débutant");
        add(debutant, 1,3,2,1);

        moyen = new RadioButton("_Moyen");
        moyen.setMnemonicParsing(true);
        moyen.setToggleGroup(groupNiveau);
        moyen.setAccessibleText("Moyen");
        add(moyen, 4,3,2,1);

        avance = new RadioButton("_Avancé");
        avance.setMnemonicParsing(true);
        avance.setToggleGroup(groupNiveau);
        avance.setAccessibleText("Avancé");
        add(avance, 1,4,2,1);

        expert = new RadioButton("_Expert");
        expert.setMnemonicParsing(true);
        expert.setToggleGroup(groupNiveau);
        expert.setAccessibleText("Expert");
        add(expert, 4,4,2,1);

        //Partie horaire
        Label horaire = new Label("_Horaire");
        horaire.setMnemonicParsing(true);
        add(horaire, 0,5,1,1);

        add(new Label("de"), 1,5,1,1);
        add(new Label("h"), 3,5,1,1);
        add(new Label("h"), 3,6,1,1);

        heure1 = new ComboBox<Integer>();
        heure2 = new ComboBox<Integer>();
        for (int i = 1; i <= 23; i++)
        {
            heure1.getItems().add(i);
            heure2.getItems().add(i);
        }

        minute1 = new ComboBox<Integer>();
        minute2 = new ComboBox<Integer>();
        for (int i = 0; i < 60; i+=15)
        {
            minute1.getItems().add(i);
            minute2.getItems().add(i);
        }

        add(heure1, 2,5,1,1);
        add(heure2, 2,6,1,1);
        add(minute1, 4,5,1,1);
        add(minute2, 4,6,1,1);

        add(new Separator(), 0,7,5,1);

        Button annuler = new Button("Annuler");
        add(annuler, 2,8,2,1);
        annuler.setAlignment(Pos.CENTER_RIGHT);
        Button save = new Button("Enregistrer");
        add(save, 4,8,1,1);
        reset();

        //Event
        annuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                reset();
            }
        });

        save.setOnAction(HBoxRoot.getControleur());
    }

    public void reset()
    {
        textFieldCours.setText("");
        debutant.setSelected(true);
        heure1.getSelectionModel().select(7);
        heure2.getSelectionModel().select(8);
        minute1.getSelectionModel().select(0);
        minute2.getSelectionModel().select(0);
    }

    public Label getTitre()
    {
        return titre;
    }

    public void setTitre(String textTitre) {
        this.titre.setText(textTitre);
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

    public String getDificulte()
    {
        if (debutant.isSelected())
            return debutant.getAccessibleText();
        else if (moyen.isSelected())
            return moyen.getAccessibleText();
        else if (avance.isSelected())
            return avance.getAccessibleText();
        else
            return expert.getAccessibleText();
    }

}
