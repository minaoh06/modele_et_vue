package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import modele.*;
import vue.DateArea;
import vue.FormulaireReservation;
import vue.HBoxRoot;

public class Controleur implements EventHandler
{
    public void handle(Event event) {
        Planning planning = HBoxRoot.getPlanning();
        FormulaireReservation reservationPane = HBoxRoot.getReservationPane();
        DateArea affichePln = HBoxRoot.getAffichagePlannig();

        // la source de event est une date du calendrier du formulaire de réservation
        if (event.getSource() instanceof ToggleButton) {
            System.out.println(((ToggleButton) event.getSource()).getUserData());
            reservationPane.setTitre(((ToggleButton) event.getSource()).getUserData().toString());
            reservationPane.getTitre().setUserData(((ToggleButton) event.getSource()).getUserData());
            DateCalendrier date = DateCalendrier.dateToDateCalendrier((Date) reservationPane.getTitre().getUserData());
            affichePln.setSemaine(date.getWeekOfYear());
            affichePln.getAreaPlanning().setText(planning.affichageSemaine(date.getWeekOfYear()));
        }

        // la source de event est le bouton "Enregistrer"
        if (event.getSource() instanceof Button)
        {
            Reservation reserve = new Reservation(
                    reservationPane.getTextFieldCours().getText(),
                    ((Date) reservationPane.getTitre().getUserData()),
                    new PlageHoraire(
                            new Horaire(reservationPane.getHeure1().getValue(), reservationPane.getMinute1().getValue()),
                            new Horaire(reservationPane.getHeure2().getValue(), reservationPane.getMinute2().getValue())
                    ),
                    reservationPane.getDificulte()
            );
            if(planning.ajout(reserve))
            {
                DateCalendrier date = DateCalendrier.dateToDateCalendrier((Date) reservationPane.getTitre().getUserData());
                affichePln.getAreaPlanning().setText(planning.affichageSemaine(date.getWeekOfYear()));
            }
            else
            {
                System.out.println("Erreur");
            }
        }
    }
}
