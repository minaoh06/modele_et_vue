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

import java.util.Collection;
import java.util.List;

import static modele.ContantesCalendrier.MOIS;

public class VBoxRoot extends VBox {
    public VBoxRoot()
    {
        DateCalendrier today = new DateCalendrier();
        StackPane moisAnne = new StackPane();

        for (int i = 0; i < 11; i++)
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
            moisAnne.getChildren().add(scroll);

        }
        //boutton et label
        HBox bouton = new HBox();
        Button recul = new Button("<");

        Button avance = new Button(">");
        bouton.getChildren().addAll(recul, avance);
        bouton.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(bouton, Priority.ALWAYS);

        HBox top = new HBox();
        Label labelTitre = new Label("2022");
        VBox.setMargin(labelTitre, new Insets(14));
        top.getChildren().addAll(labelTitre, bouton);

        this.getChildren().addAll(top, moisAnne);

        List<Node> listMoisStack = moisAnne.getChildren();

        recul.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Recule");
                listMoisStack.get(listMoisStack.size()-1).toBack();
            }
        });

        avance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Avance");
                listMoisStack.get(0).toFront();
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
