/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.pkg1.controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.pkg1.services.AssociationListController;
import pidev.pkg1.entities.Association;

public class AddAssociationListController {

    AssociationListController associationListController = new AssociationListController();

    @FXML private Button addButton;

    @FXML private TextField nomAdd;
    @FXML private TextField adressAdd;
    @FXML private TextField phoneAdd;
    @FXML private TextField mailAdd;
    @FXML private TextField descAdd;
    @FXML private TextField imageAdd;
    @FXML private TextField categoryIdAdd;

    @FXML
    private void initialize() {}

    @FXML
    private void handleCreatingNewAssociation() {
        System.out.println("Creating new association");
        associationListController.addAssociation(new Association(
                nomAdd.getText(),
                adressAdd.getText(),
                phoneAdd.getText(),
                mailAdd.getText(),
                descAdd.getText(),
                Integer.parseInt(categoryIdAdd.getText()),
                imageAdd.getText(),
                0
        ));
        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();
    }

}
