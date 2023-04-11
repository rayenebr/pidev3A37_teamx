package evene.gui;

import evene.entities.Event;
import evene.services.EventService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEventController {

    EventService eventService = new EventService();

    @FXML private TextField titre;
    @FXML private TextField adresse;
    @FXML private TextField dateStart;
    @FXML private TextField dateEnd;
    @FXML private TextField content;
    @FXML private TextField std;
    @FXML private TextField vip;
    @FXML private TextField tickets;
    @FXML private TextField image;

    @FXML private Button save;

    @FXML private void saveNewEvent() {
        eventService.addEvent(new Event(
                titre.getText(),
                adresse.getText(),
                dateStart.getText(),
                dateEnd.getText(),
                content.getText(),
                Double.parseDouble(std.getText()),
                Double.parseDouble(vip.getText()),
                Integer.parseInt(tickets.getText()),
                image.getText(),
                0));
        Stage stage = (Stage) save.getScene().getWindow();
        stage.close();
    }

}
