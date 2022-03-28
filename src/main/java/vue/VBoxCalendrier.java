package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import modele.CalendrierDuMois;
import modele.DateCalendrier;

import java.util.Collection;
import java.util.List;

import static modele.ContantesCalendrier.*;

public class VBoxCalendrier extends VBox
{
    public VBoxCalendrier()
    {
        /*En-tete*/
        //Button
        HBox boxButton = new HBox();
        boxButton.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(boxButton, Priority.ALWAYS);

        Button buttonReculMax = new Button("<<");
        boxButton.getChildren().add(buttonReculMax);

        Button buttonRecul = new Button("<");
        boxButton.getChildren().add(buttonRecul);

        Button buttonAvance = new Button(">");
        boxButton.getChildren().add(buttonAvance);

        Button buttonAvanceMax = new Button(">>");
        boxButton.getChildren().add(buttonAvanceMax);

        //Label
        Label labelTitre = new Label("2022");
        VBox.setMargin(labelTitre, new Insets(20));


        //En-tête calendrier
        HBox topCal = new HBox();
        VBox.setMargin(topCal, new Insets(10));
        HBox.setMargin(topCal, new Insets(10));
        topCal.getChildren().addAll(labelTitre, boxButton);
        this.getChildren().add(topCal);


        /*Calendrier*/
        //Date
        DateCalendrier today = new DateCalendrier();
        int anneeActu = 2022;


        //StackPane
        StackPane moisAnne = new StackPane();
        List<Node> listMoisStack = moisAnne.getChildren();


        //initialisation des mois
        for(int i = 0; i < 11; i++)
        {
            //Calendrier
            CalendrierDuMois cal = new CalendrierDuMois(i, anneeActu);
            GridPane date = new GridPane();
            date.setHgap(30);
            date.setVgap(20);
            for(int j = 0; j < INITIAL_JOURS_SEMAINE.length; j++)
            {
                Label inJour = new Label(INITIAL_JOURS_SEMAINE[j]);
                date.add(inJour, j,0,1,1);
            }

            //Ajout des dates à l'affichage
            Collection<DateCalendrier> tabDates = cal.getDates();
            int i1 = 0;
            int i2 = 1;
            for (DateCalendrier x : tabDates)
            {
                //label
                Label lab = new Label("" + x.getJour());
                VBox.setMargin(lab,new Insets(8));

                //Grid Pan
                date.add(lab, i1, i2, 1, 1);
                if (i1 == 6)
                {
                    i1 = 0;
                    i2 += 1;
                }
                else
                {
                    i1 += 1;
                }

                //ajout des Id pour le CSS
                if (x.getMois() != i)
                {
                    date.getChildren().get(date.getChildren().size() - 1).setId("horsMois");
                }
                if (x.compareTo(today) == 0)
                {
                    date.getChildren().get(date.getChildren().size() - 1).setId("today");
                }
            }
            date.setVisible(false);
            date.setAccessibleText(MOIS[i]);
            moisAnne.getChildren().add(date);
        }
        this.getChildren().add(moisAnne);


        /*Event*/
        buttonRecul.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Recule");
                listMoisStack.get(0).setVisible(false);
                listMoisStack.get(listMoisStack.size()-1).toBack();
                System.out.println(listMoisStack.get(0).getAccessibleText());
                listMoisStack.get(0).setVisible(true);
            }
        });

        buttonAvance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Avance");
                listMoisStack.get(0).setVisible(false);
                listMoisStack.get(0).toFront();
                System.out.println(listMoisStack.get(0).getAccessibleText());
                listMoisStack.get(0).setVisible(true);
            }
        });

        buttonReculMax.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Recule Max");
                listMoisStack.get(0).setVisible(false);
                while (listMoisStack.get(listMoisStack.size()-1).getAccessibleText().compareTo(MOIS[0]) != 0)
                {
                    listMoisStack.get(listMoisStack.size()-1).toBack();
                    System.out.println(listMoisStack.get(0).getAccessibleText());
                }
                listMoisStack.get(0).setVisible(true);
            }
        });

        buttonAvanceMax.setOnAction((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Avance Max");
                listMoisStack.get(0).setVisible(false);
                while (listMoisStack.get(0).getAccessibleText().compareTo(MOIS[11]) != 0)
                {
                    listMoisStack.get(0).toFront();
                    System.out.println(listMoisStack.get(0).getAccessibleText());
                }
                listMoisStack.get(0).setVisible(true);
            }
        }));

        //accès au mois courant
        while (listMoisStack.get(0).getAccessibleText().compareTo(MOIS[today.getMois()]) != 0)
        {
            listMoisStack.get(0).toFront();
            System.out.println(listMoisStack.get(0).getAccessibleText());
        }
        listMoisStack.get(0).setVisible(true);
    }
}
