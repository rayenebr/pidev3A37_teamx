/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.pkg1.controllers;
import pidev.pkg1.entities.Association;
import pidev.pkg1.entities.AssociationCategory;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.pkg1.services.AssociationCategoryService;

public class AddAssociationCategoryController {

    AssociationCategoryService associationCategoryService = new AssociationCategoryService();


    @FXML
    private TextField TFedit;

    @FXML
    private Button btn;

    @FXML
    private void initialize() {
    }

    @FXML
    private void addAssociationCategory() {
        associationCategoryService.addAssociationCategory(new AssociationCategory(TFedit.getText()));
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

}
