package evene.gui;

import evene.entities.Reservation;
import evene.services.ReservationService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddReservationController {

   ReservationService rs = new ReservationService();

    @FXML private TextField res_event;
    @FXML private TextField date_res;
    @FXML private TextField nb_res;
    @FXML private TextField holder_res;
    @FXML private TextField type_res;
    @FXML private TextField res_user;

    @FXML private Button addRes;

    @FXML private void addReservation(){
        rs.addReservation(new Reservation(
                Integer.parseInt(res_event.getText()),
                date_res.getText(),
                Integer.parseInt(nb_res.getText()),
                holder_res.getText(),
                type_res.getText(),
                Integer.parseInt(res_user.getText())
        ));
        Stage stage = (Stage) addRes.getScene().getWindow();
        stage.close();
    }

}
