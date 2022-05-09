package vue;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import modele.Planning;

public class HBoxRoot extends HBox
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

    public static TextArea getAffichagePlannig() {
        return affichagePlannig.getAreaPlanning();
    }
}
