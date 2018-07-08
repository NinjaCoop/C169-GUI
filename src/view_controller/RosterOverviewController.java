/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import c169_gui.MainApp;
import model.Student;

/**
 * FXML Controller class
 *
 * @author sinjincooper
 */
public class RosterOverviewController {
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, String> firstNameColumn;
    @FXML
    private TableColumn<Student, String> lastNameColumn;
    
    @FXML
    private Label idLabel;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label ageLabel;
    /*@FXML
    private Label gradesLabel;*/
    
    private MainApp mainApp;
    
    public RosterOverviewController() {
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    private void initialize() {
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    }    
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        studentTable.setItems(mainApp.getStudentData());
    }
}
