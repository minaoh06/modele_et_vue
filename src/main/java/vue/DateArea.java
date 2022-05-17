package vue;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import modele.DateCalendrier;

public class DateArea extends VBox
{
    private TextArea areaPlanning;
    private Label semaine;

    public DateArea()
    {
        semaine = new Label("Semaine " + new DateCalendrier().getWeekOfYear());
        getChildren().add(semaine);

        areaPlanning = new TextArea();
        areaPlanning.setMaxSize(255, 330);
        areaPlanning.setEditable(false);
        areaPlanning.setWrapText(true);
        getChildren().add(areaPlanning);
    }

    public TextArea getAreaPlanning()
    {
        return areaPlanning;
    }

    public void setSemaine(int numSem)
    {
        semaine.setText("Semaine " + numSem);
    }
}
