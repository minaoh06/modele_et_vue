package vue;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import modele.Planning;

public class HBoxRoot extends HBox
{
    public static Planning planning;
    public static Controleur controleur;
    public static FormulaireReservation reservationPane;
    public static VBoxCalendrier calendrierPane;

    public HBoxRoot()
    {
        planning = new Planning();
        controleur = new Controleur();
        reservationPane = new FormulaireReservation();
        calendrierPane = new VBoxCalendrier();

        getChildren().addAll(calendrierPane, reservationPane);
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

}
