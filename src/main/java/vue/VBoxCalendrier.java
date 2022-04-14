package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import modele.CalendrierDuMois;
import modele.DateCalendrier;

import java.util.List;

import static modele.ContantesCalendrier.JOURS_ABR;
import static modele.ContantesCalendrier.MOIS;

public class VBoxCalendrier extends VBox
{
    public VBoxCalendrier()
    {
                /*Boutton et label*/
        //Boutton
        HBox boxBouton = new HBox(5);
        boxBouton.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(boxBouton, Priority.ALWAYS);

        Button reculMax = new Button("<<");
        boxBouton.getChildren().add(reculMax);

        Button recul = new Button("<");
        boxBouton.getChildren().add(recul);

        Button avance = new Button(">");
        boxBouton.getChildren().add(avance);

        Button avanceMax = new Button(">>");
        boxBouton.getChildren().add(avanceMax);

        //Label
        Label labelTitre = new Label("Mars");

        //Box top
        HBox top = new HBox(5);
        top.setPadding(new Insets(20));
        VBox.setMargin(labelTitre, new Insets(14));
        top.getChildren().addAll(boxBouton, labelTitre);


                    /*Calendrier*/
        DateCalendrier today = new DateCalendrier();
        StackPane moisAnne = new StackPane();
        ToggleGroup jours = new ToggleGroup();

        for (int i = 0; i <= 11; i++)
        {
            CalendrierDuMois cal = new CalendrierDuMois(i+1, 2022);
            TilePane date = new TilePane();
            date.setPrefColumns(7);
            date.setPrefRows(cal.getDates().size() /7 + 1);
            date.setHgap(10);
            date.setVgap(10);
            date.setMaxWidth(270);
            date.setMinWidth(270);
            date.setLayoutX(7);
            date.setId("opaque");
            VBox.setMargin(date, new Insets(4));

            for (String x : JOURS_ABR)
            {
                date.getChildren().add(new Label(x));
            }

            for (DateCalendrier x : cal.getDates())
            {
                ToggleButton jour = new ToggleButton(""+x.getJour());
                jour.setToggleGroup(jours);
                VBox.setMargin(jour,new Insets(8));
                date.getChildren().add(jour);

                //Ajout des ID
                if (x.getMois() != i+1)
                {
                    jour.setId("horsMois");
                }
                if (x.compareTo(today) == 0)
                {
                    jour.setId("today");
                    jour.setSelected(true);
                }
                jour.setUserData(x);
                jour.setOnAction(HBoxRoot.getControleur());
            }
            date.setAccessibleText(MOIS[i]);
            moisAnne.getChildren().add(date);

        }
        VBox.setMargin(moisAnne, new Insets(10));
        this.getChildren().add(moisAnne);
        this.getChildren().add(top);

        List<Node> listMoisStack = moisAnne.getChildren();


                            /*Event*/
        recul.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Recule");
                listMoisStack.get(listMoisStack.size()-1).toBack();
                labelTitre.setText(listMoisStack.get(listMoisStack.size()-1).getAccessibleText());
            }
        });

        reculMax.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Recule Max");
                while(listMoisStack.get(listMoisStack.size()-1).getAccessibleText().compareTo(MOIS[0]) != 0)
                {
                listMoisStack.get(listMoisStack.size()-1).toBack();
                }
                labelTitre.setText(listMoisStack.get(listMoisStack.size()-1).getAccessibleText());
            }
        });

        avance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Avance");
                listMoisStack.get(0).toFront();
                labelTitre.setText(listMoisStack.get(listMoisStack.size()-1).getAccessibleText());
            }
        });

        avanceMax.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Recule Max");
                while(listMoisStack.get(listMoisStack.size()-1).getAccessibleText().compareTo(MOIS[11]) != 0)
                {
                    listMoisStack.get(0).toFront();
                }
                labelTitre.setText(listMoisStack.get(listMoisStack.size()-1).getAccessibleText());
            }
        });

        //accès au mois courant
        while (listMoisStack.get(0).getAccessibleText().compareTo(MOIS[today.getMois()]) != 0)
        {
            listMoisStack.get(0).toFront();
        }
    }
}
