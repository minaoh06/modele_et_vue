package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import modele.CalendrierDuMois;
import modele.DateCalendrier;

import java.util.List;

import static modele.ContantesCalendrier.MOIS;

public class VBoxCalendrier extends VBox
{
    public VBoxCalendrier()
    {
                /*Boutton et label*/
        //Boutton
        HBox bouton = new HBox();
        bouton.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(bouton, Priority.ALWAYS);

        Button recul = new Button("<");
        bouton.getChildren().add(recul);

        Button avance = new Button(">");
        bouton.getChildren().add(avance);

        //Label
        Label labelTitre = new Label("Mars");

        //Box top
        HBox top = new HBox();
        VBox.setMargin(labelTitre, new Insets(14));
        top.getChildren().addAll(labelTitre, bouton);
        this.getChildren().add(top);

                    /*Calendrier*/
        DateCalendrier today = new DateCalendrier();


        StackPane moisAnne = new StackPane();

        for (int i = 0; i <= 11; i++)
        {
            CalendrierDuMois cal = new CalendrierDuMois(i+1, 2022);
            VBox date = new VBox();
            ScrollPane scroll = new ScrollPane();
            scroll.setContent(date);
            VBox.setMargin(scroll, new Insets(4));

            for (DateCalendrier x : cal.getDates())
            {
                Label lab = new Label(x.toString());
                VBox.setMargin(lab,new Insets(8));
                date.getChildren().add(lab);

                //Ajout des ID
                if (x.getMois() != i+1)
                {
                    date.getChildren().get(date.getChildren().size() - 1).setId("horsMois");
                }
                if (x.compareTo(today) == 0)
                {
                    date.getChildren().get(date.getChildren().size() - 1).setId("today");
                }
            }
            scroll.setAccessibleText(MOIS[i]);
            System.out.println(MOIS[i] + " " + i);
            moisAnne.getChildren().add(scroll);

        }
        this.getChildren().add(moisAnne);

        List<Node> listMoisStack = moisAnne.getChildren();

                            /*Event*/
        recul.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Recule");
                listMoisStack.get(listMoisStack.size()-1).toBack();
                labelTitre.setText(listMoisStack.get(0).getAccessibleText());
            }
        });

        avance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Avance");
                listMoisStack.get(0).toFront();
                labelTitre.setText(listMoisStack.get(0).getAccessibleText());
            }
        });

        //accès au mois courant
        while (listMoisStack.get(0).getAccessibleText().compareTo(MOIS[today.getMois()]) != 0)
        {
            listMoisStack.get(0).toFront();
            //System.out.println(listMoisStack.get(listMoisStack.size()-1).getAccessibleText());
        }
    }
}
