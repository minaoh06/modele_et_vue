package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import modele.*;
import vue.FormulaireReservation;
import vue.HBoxRoot;

public class Controleur implements EventHandler
{
    public void handle(Event event) {
        Planning planning = HBoxRoot.getPlanning();
        FormulaireReservation reservationPane = HBoxRoot.getReservationPane();

        // la source de event est une date du calendrier du formulaire de réservation
        if (event.getSource() instanceof ToggleButton)
        {
            System.out.println(((ToggleButton) event.getSource()).getUserData());
            reservationPane.getTitre().setText(((ToggleButton) event.getSource()).getUserData().toString());
            reservationPane.getTitre().setUserData(((ToggleButton) event.getSource()).getUserData());
        }

        // la source de event est le bouton "Enregistrer"
        if (event.getSource() instanceof Button)
        {
            planning.ajout(new Reservation(
                    reservationPane.getTextFieldCours().getText(),
                    ((Date) reservationPane.getTitre().getUserData()),
                    new PlageHoraire(
                            new Horaire(reservationPane.getHeure1().getValue(), reservationPane.getMinute1().getValue()),
                            new Horaire(reservationPane.getHeure2().getValue(), reservationPane.getMinute2().getValue())
                            )
            ));
            System.out.println("lol");
        }
    }
}
