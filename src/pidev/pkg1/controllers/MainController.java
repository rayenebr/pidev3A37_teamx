package pidev.pkg1.controllers;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.List;
import pidev.pkg1.PIDEV1;
import pidev.pkg1.services.AssociationCategoryService;
import pidev.pkg1.services.AssociationListController;
import pidev.pkg1.entities.Association;
import pidev.pkg1.entities.AssociationCategory;



public class MainController {

    

    private AssociationCategoryService associationCategoryController = new AssociationCategoryService();
    private AssociationListController associationListController = new AssociationListController();

    /**
     * association category table
     */
    @FXML
    private TableView<AssociationCategory> categoryTableView;
    @FXML
    private TableColumn<AssociationCategory, Integer> idColumn;
    @FXML
    private TableColumn<AssociationCategory, String> typeColumn;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addButton;
    @FXML
    private Button showButton;
    @FXML
    private Button editCategory;
    @FXML
    private TextField editTextField;

    /**
     * association list table
     */
    @FXML
    TableView<Association> associationTableView;
    @FXML
    private TableColumn<Association, Integer> idAsso;
    @FXML
    private TableColumn<Association, String> nomAsso;
    @FXML
    private TableColumn<Association, String> mailAsso;
    @FXML
    private TableColumn<Association, String> numTelAsso;
    @FXML
    private TableColumn<Association, String> adresseAsso;
    @FXML
    private TableColumn<Association, Integer> viewAsso;
    @FXML
    private TableColumn<Association, String> categoryAsso;
    @FXML
    private TableColumn<Association, String> descAsso;
    @FXML
    private Button deleteAsso;
    @FXML
    private Button show;
    @FXML
    private Button addAsso;

    @FXML
    private Button btnRefrech;


    /**
     * fetch data for edit
     */
    @FXML private Button updateList;
    @FXML private TextField nomEdit;
    @FXML private TextField mailEdit;
    @FXML private TextField numEdit;
    @FXML private TextField adresseEdit;
    @FXML private TextField descEdit;
    @FXML private TextField imageEdit;
    @FXML private TextField categoryIdEdit;
    /****************** */

    @FXML
    public void initialize() {
        System.out.println("Initializing category table ...");
        initCategoriesTable();

        System.out.println("Initializing association table ...");
        initAssociationTable();
    }

    @FXML
    public void refetch() {
        System.out.println("test");
        initCategoriesTable();
        categoryTableView.refresh();
        initAssociationTable();
        associationTableView.refresh();
    }

    // categories
    private void initCategoriesTable() {
        List<AssociationCategory> categories = fetchCategories();

        idColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<AssociationCategory, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<AssociationCategory, Integer> param) {
                return new SimpleIntegerProperty(param.getValue().getId()).asObject();
            }
        });

        typeColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<AssociationCategory, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<AssociationCategory, String> param) {
                return new SimpleStringProperty(param.getValue().getType());
            }
        });

        categoryTableView.setItems(FXCollections.observableList(categories));
    }
    private List<AssociationCategory> fetchCategories() {
        return associationCategoryController.getAllAssociationCategories();
    }
    @FXML
    private void deleteCategoryFromTable(ActionEvent event) {
        AssociationCategory idCaptured = categoryTableView.getSelectionModel().getSelectedItem();
        categoryTableView.getItems().remove(idCaptured);
        associationCategoryController.deleteAssociationCategory(idCaptured.getId());
        System.out.println("deleted => " + idCaptured.toString());
        categoryTableView.refresh();
    }
    @FXML
    private void openAddCategoryWindow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(PIDEV1.class.getResource("addAssociationCategory.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
    @FXML
    private void showCategoryWhenSelected(ActionEvent event) {
        AssociationCategory idCaptured = categoryTableView.getSelectionModel().getSelectedItem();
        editTextField.setText(idCaptured.getType());
    }
    @FXML
    private void updateCategoryThatIsChanged(ActionEvent event) {
        Integer idCaptured = categoryTableView.getSelectionModel().getSelectedItem().getId();
        associationCategoryController.updateAssociationCategory(new AssociationCategory(idCaptured ,editTextField.getText()));
        initCategoriesTable();
        categoryTableView.refresh();
    }


    // associations
    private void initAssociationTable() {
        List<Association> associations = fetchAssociations();

        idAsso.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Association, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Association, Integer> param) {
                return new SimpleIntegerProperty(param.getValue().getId()).asObject();
            }
        });

        nomAsso.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Association, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Association, String> param) {
                return new SimpleStringProperty(param.getValue().getNom());
            }
        });

        mailAsso.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Association, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Association, String> param) {
                return new SimpleStringProperty(param.getValue().getMail());
            }
        });

        numTelAsso.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Association, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Association, String> param) {
                return new SimpleStringProperty(param.getValue().getNum_tel());
            }
        });

        adresseAsso.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Association, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Association, String> param) {
                return new SimpleStringProperty(param.getValue().getAdresse());
            }
        });

        viewAsso.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Association, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Association, Integer> param) {
                return new SimpleIntegerProperty(param.getValue().getView_count()).asObject();
            }
        });

        categoryAsso.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Association, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Association, String> param) {
                String type = associationCategoryController.getAssociationCategoryById(param.getValue().getCategory_type_id()).getType();
                return new SimpleStringProperty(type);
            }
        });

        descAsso.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Association, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Association, String> param) {
                return new SimpleStringProperty(param.getValue().getDescription());
            }
        });

        associationTableView.setItems(FXCollections.observableList(associations));
    }
    private List<Association> fetchAssociations() {
        return associationListController.getAllAssociationList();
    }
    @FXML
    private void deleteAssociationFromTable(ActionEvent event) {
        Association idCaptured = associationTableView.getSelectionModel().getSelectedItem();
        associationTableView.getItems().remove(idCaptured);
        associationListController.deleteAssociation(idCaptured.getId());
        System.out.println("deleted => " + idCaptured.toString());
        associationTableView.refresh();
    }
    @FXML
    private void showAssociaionWhenSelected(ActionEvent event) {
        Association idCaptured = associationTableView.getSelectionModel().getSelectedItem();
        nomEdit.setText(idCaptured.getNom());
        mailEdit.setText(idCaptured.getMail());
        numEdit.setText(idCaptured.getNum_tel());
        adresseEdit.setText(idCaptured.getAdresse());
        descEdit.setText(idCaptured.getDescription());
        imageEdit.setText(idCaptured.getImage());
        categoryIdEdit.setText(idCaptured.getCategory_type_id().toString());
    }
    @FXML
    private void updateAssociationThatIsChanged(ActionEvent event) {
        Integer idCaptured = associationTableView.getSelectionModel().getSelectedItem().getId();
        associationListController.updateAssociation(new Association(
                idCaptured,
                nomEdit.getText(),
                adresseEdit.getText(),
                numEdit.getText(),
                mailEdit.getText(),
                descEdit.getText(),
                Integer.parseInt(categoryIdEdit.getText()),
                imageEdit.getText(),
                null
                )
        );
        initAssociationTable();
        associationTableView.refresh();
    }
    @FXML
    private void openAddAssociationWindow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(PIDEV1.class.getResource("addAssociationList.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }

}