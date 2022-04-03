package vue;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

        //ComboBox


        //ComboBox<String> annee = new ComboBox<>();
        //annee.setItems();
        /*for (int i = 2000; i < 2050; i++) {

        }*/

        //En-tête calendrier
        HBox topCal = new HBox();
        VBox.setMargin(topCal, new Insets(20));
        topCal.getChildren().addAll(labelTitre, boxButton);
        this.getChildren().add(topCal);


                        /*Calendrier*/
        //Date
        DateCalendrier today = new DateCalendrier();
        int anneeActu = 2022;

        //StackPane
        StackPane moisAnne = anneeMois(2022);
        List<Node> listMoisStack = moisAnne.getChildren();
        this.getChildren().add(moisAnne);


                            /*Event*/
        buttonRecul.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Recule");
                listMoisStack.get(0).setVisible(false);
                listMoisStack.get(listMoisStack.size()-1).toBack();
//                System.out.println(listMoisStack.get(0).getAccessibleText());
                listMoisStack.get(0).setVisible(true);
            }
        });

        buttonAvance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Avance");
                listMoisStack.get(0).setVisible(false);
                listMoisStack.get(0).toFront();
//                System.out.println(listMoisStack.get(0).getAccessibleText());
                listMoisStack.get(0).setVisible(true);
            }
        });

        buttonReculMax.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Recule Max");
                listMoisStack.get(0).setVisible(false);
                while (listMoisStack.get(listMoisStack.size()-1).getAccessibleText().compareTo(MOIS[11]) != 0)
                {
                    listMoisStack.get(listMoisStack.size()-1).toBack();
                }
//                System.out.println(listMoisStack.get(0).getAccessibleText());
                listMoisStack.get(0).setVisible(true);
            }
        });

        buttonAvanceMax.setOnAction((new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Avance Max");
                listMoisStack.get(0).setVisible(false);
                while (listMoisStack.get(0).getAccessibleText().compareTo(MOIS[11]) != 0)
                {
                    listMoisStack.get(0).toFront();
                }
//                System.out.println(listMoisStack.get(11).getAccessibleText());
                listMoisStack.get(0).setVisible(true);
            }
        }));

        //accès au mois courant
        while (listMoisStack.get(0).getAccessibleText().compareTo(MOIS[today.getMois()-1]) != 0)
        {
            listMoisStack.get(0).toFront();
//            System.out.println(listMoisStack.get(0).getAccessibleText());
        }
        listMoisStack.get(0).setVisible(true);
    }

    private StackPane anneeMois(int annee)
    {
        DateCalendrier today = new DateCalendrier();

        //StackPane
        StackPane moisAnne = new StackPane();

        //initialisation des mois
        for(int i = 0; i <= 11; i++)
        {
            VBox calendrierEtLabel = new VBox(10);
            calendrierEtLabel.setAlignment(Pos.TOP_CENTER);
            //HBox.setMargin(calendrierEtLabel, new Insets(20));


            //Label du mois
            calendrierEtLabel.getChildren().add(new Label(MOIS[i]));
            calendrierEtLabel.getChildren().get(calendrierEtLabel.getChildren().size()-1).setId("mois");

            //System.out.println(MOIS[i]);
            //Calendrier
            CalendrierDuMois cal = new CalendrierDuMois(i+1, annee);
            GridPane date = new GridPane();
            date.setAlignment(Pos.CENTER);
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
                if (x.getMois() != i+1)
                {
                    date.getChildren().get(date.getChildren().size() - 1).setId("horsMois");
                }
                if (x.compareTo(today) == 0)
                {
                    date.getChildren().get(date.getChildren().size() - 1).setId("today");
                }
            }
            calendrierEtLabel.setVisible(false);
            calendrierEtLabel.setAccessibleText(MOIS[i]);
            calendrierEtLabel.getChildren().add(date);
            moisAnne.getChildren().add(calendrierEtLabel);
        }
        return moisAnne;
    }
}
