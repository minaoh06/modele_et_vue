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
    public static TextPlaning affichagePlannig;

    public HBoxRoot(int gap)
    {
        super(gap);
        planning = new Planning();
        controleur = new Controleur();
        reservationPane = new FormulaireReservation();
        calendrierPane = new VBoxCalendrier();
        affichagePlannig = new TextPlaning();

        getChildren().addAll(calendrierPane, reservationPane, affichagePlannig);
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

    public static TextPlaning getAffichagePlannig() {
        return affichagePlannig;
    }
}
