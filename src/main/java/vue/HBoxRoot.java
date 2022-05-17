package vue;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import modele.Planning;

import static modele.ContantesCalendrier.MOIS;


public class HBoxRoot extends HBox implements modele.Menu
{
    private static Planning planning;
    private static Controleur controleur;
    private static FormulaireReservation reservationPane;
    private static VBoxCalendrier calendrierPane;
    private static DateArea affichagePlannig;

    public HBoxRoot(int gap)
    {
        super(gap);
        planning = new Planning();
        controleur = new Controleur();
        reservationPane = new FormulaireReservation();
        calendrierPane = new VBoxCalendrier();
        affichagePlannig = new DateArea();

        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu(INTITULE_MENU_PLANNING);
        menuBar.getMenus().add(menu);
        getChildren().add(menuBar);
        

        Node [] compenents = new Node[3];
        compenents[0] = calendrierPane;
        compenents[1] = reservationPane;
        compenents[2] = affichagePlannig;
        calendrierPane.setId("back");
        reservationPane.setId("back");
        affichagePlannig.setId("back");

        StackPane stackPane = new StackPane(compenents);
        stackPane.getChildren().get(0).toFront();

        getChildren().add(stackPane);

        //getChildren().addAll(calendrierPane, reservationPane, affichagePlannig);

        for (int i = 0; i < ITEMS_MENU_PLANNING.length; i++) {
            MenuItem menuItem = new MenuItem(ITEMS_MENU_PLANNING[i]);
            menuItem.setUserData(i);
            menuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    int data = (int)((MenuItem)actionEvent.getSource()).getUserData();
                    while ((stackPane.getChildren().get(0).getUserData()).equals(data))
                    {
                        stackPane.getChildren().get(0).toFront();
                    }
                }
            });
            menu.getItems().add(menuItem);
        }
    }

    public static EventHandler<ActionEvent> getControleur() {
        return controleur;
    }

    public static Planning getPlanning()
    {
        return planning;
    }

    public static FormulaireReservation getReservationPane()
    {
        return reservationPane;
    }

    public static VBoxCalendrier getCalendrierPane()
    {
        return calendrierPane;
    }

    public static DateArea getAffichagePlannig() {
        return affichagePlannig;
    }
}
