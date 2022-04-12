package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import modele.Planning;
import vue.FormulaireReservation;
import vue.HBoxRoot;

public class Controleur implements EventHandler
{
    public void handle(Event event) {
        Planning planning = HBoxRoot.getPlanning();
        FormulaireReservation reservationPane = HBoxRoot.getReservationPane();

        // la source de event est une date du calendrier du formulaire de réservation
        if (event.getSource() instanceof ToggleButton) {
            System.out.println(((ToggleButton) event.getSource()).getUserData());
            reservationPane.getTitre().setText(((ToggleButton) event.getSource()).getUserData().toString());
        }

        // la source de event est le bouton "Enregistrer"
        if (event.getSource() instanceof Button) {
        // à compléter
        }
    }
}
