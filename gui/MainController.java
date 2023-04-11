package evene.gui;

import evene.Evene;
import evene.entities.Event;
import evene.entities.Reservation;
import evene.services.EventService;
import evene.services.ReservationService;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class MainController {

    EventService eventService = new EventService();
    ReservationService reservationService = new ReservationService();

    @FXML private TableView<Event> eventTableView;
    @FXML private TableColumn<Event, Integer> id;
    @FXML private TableColumn<Event, String> titre;
    @FXML private TableColumn<Event, String> adresse;
    @FXML private TableColumn<Event, String> dateStart;
    @FXML private TableColumn<Event, String> dateEnd;
    @FXML private TableColumn<Event, String> content;
    @FXML private TableColumn<Event, String> std;
    @FXML private TableColumn<Event, String> vip;
    @FXML private TableColumn<Event, String> tickets;
    @FXML private TableColumn<Event, String> image;
    @FXML private TableColumn<Event, String> views;

    @FXML private Button refresh;
    @FXML private Button deleteEvent;
    @FXML private Button openAdd;


    @FXML private TableView<Reservation> reservationTableView;
    @FXML private TableColumn<Reservation, Integer> id_res;
    @FXML private TableColumn<Reservation, String> res_res;
    @FXML private TableColumn<Reservation, Integer> nb_res;
    @FXML private TableColumn<Reservation, String> holder_res;
    @FXML private TableColumn<Reservation, String> type_res;
    @FXML private TableColumn<Reservation, Integer> event_res;
    @FXML private TableColumn<Reservation, Integer> user_res;

    @FXML private Button deleteReservation;
    @FXML private Button addReservation;

    @FXML
    public void initialize() {
        System.out.println("Initializing event table ...");
        initEventsData();
        initReservationData();
    }

    @FXML
    private void refetch() {
        initEventsData();
        eventTableView.refresh();
        initReservationData();
        reservationTableView.refresh();
    }

    public void initEventsData() {
        List<Event> events = fetchEvents();

        id.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Event, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Event, Integer> param) {
                return new SimpleIntegerProperty(param.getValue().getId()).asObject();
            }
        });

        titre.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Event, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Event, String> param) {
                return new SimpleStringProperty(param.getValue().getTitle());
            }
        });

        adresse.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Event, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Event, String> param) {
                return new SimpleStringProperty(param.getValue().getAddress());
            }
        });

        vip.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Event, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Event, String> param) {
                return new SimpleStringProperty(String.valueOf(param.getValue().getVipPrice()));
            }
        });

        std.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Event, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Event, String> param) {
                return new SimpleStringProperty(String.valueOf(param.getValue().getStandardPrice()));
            }
        });

        tickets.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Event, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Event, String> param) {
                return new SimpleStringProperty(String.valueOf(param.getValue().getMaxTickets()));
            }
        });

        content.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Event, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Event, String> param) {
                return new SimpleStringProperty(param.getValue().getContent());
            }
        });


        dateStart.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Event, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Event, String> param) {
                return new SimpleStringProperty(param.getValue().getStartDate().toString());
            }
        });

        dateEnd.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Event, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Event, String> param) {
                return new SimpleStringProperty(param.getValue().getEndDate().toString());
            }
        });

        image.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Event, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Event, String> param) {
                return new SimpleStringProperty(param.getValue().getImage());
            }
        });

        views.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Event, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Event, String> param) {
                return new SimpleStringProperty(String.valueOf(param.getValue().getViewCount()));
            }
        });

        eventTableView.setItems(FXCollections.observableList(events));
    }
    private List<Event> fetchEvents() {
        return eventService.getAll();
    }
    @FXML private void deleteFromTable(ActionEvent event) {
        Event idCaptured = eventTableView.getSelectionModel().getSelectedItem();
        eventTableView.getItems().remove(idCaptured);
        eventService.deleteEvent(idCaptured.getId());
        System.out.println("deleted => " + idCaptured.toString());
        eventTableView.refresh();
    }
    @FXML private void openAddEvent(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Evene.class.getResource("addEvent.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }


    public void initReservationData() {
        List<Reservation> reservations = fetchReservations();
System.out.println(reservations);
        id_res.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reservation, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Reservation, Integer> param) {
                return new SimpleIntegerProperty(param.getValue().getId()).asObject();
            }
        });

        res_res.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reservation, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Reservation, String> param) {
                return new SimpleStringProperty(param.getValue().getReservationDate().toString());
            }
        });

        nb_res.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reservation, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Reservation, Integer> param) {
                return new SimpleIntegerProperty((int) param.getValue().getNumberOfTickets()).asObject();
            }
        });

        holder_res.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reservation, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Reservation, String> param) {
                return new SimpleStringProperty(param.getValue().getNameHolder());
            }
        });
type_res.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reservation, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Reservation, String> param) {
                return new SimpleStringProperty(param.getValue().getReservationType());
            }
        });
        

        event_res.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reservation, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Reservation, Integer> param) {
                return new SimpleIntegerProperty(param.getValue().getEventId()).asObject();
            }
        });

        user_res.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reservation, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Reservation, Integer> param) {
                return new SimpleIntegerProperty(param.getValue().getUserId()).asObject();
            }
        });

        reservationTableView.setItems(FXCollections.observableList(reservations));
    }
    public List<Reservation> fetchReservations() {
        return reservationService.getAll();
    }
    @FXML private void deleteFunctionReservation(ActionEvent event) {
        Reservation idCaptured = reservationTableView.getSelectionModel().getSelectedItem();
        reservationTableView.getItems().remove(idCaptured);
        reservationService.deleteReservation(idCaptured.getId());
        System.out.println("deleted => " + idCaptured.toString());
        reservationTableView.refresh();
    }
    @FXML private void addReservationOpen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Evene.class.getResource("addReservation.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }}