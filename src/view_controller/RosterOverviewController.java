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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
        firstNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().lastNameProperty());
        
        showStudentDetails(null);
        
        studentTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showStudentDetails(newValue));
    }    
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        studentTable.setItems(mainApp.getStudentData());
    }
    
    private void showStudentDetails(Student student) {
        if (student != null) {
            idLabel.setText(student.getId());
            firstNameLabel.setText(student.getFirstName());
            lastNameLabel.setText(student.getLastName());
            emailLabel.setText(student.getEmail());
            ageLabel.setText(Integer.toString(student.getAge()));
            //TODO convert grades arraylist into string.
            //gradesLabel.setText(something something);
        } else {
            idLabel.setText("");
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            emailLabel.setText("");
            ageLabel.setText("");
            //gradesLabel.setText("");
        }
    }
    
    @FXML
    private void handleDeleteStudent() {
        int selectedIndex = studentTable.getSelectionModel().getSelectedIndex();
        
        if (selectedIndex >= 0) {
        studentTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Student Selected");
            alert.setContentText("Please select a student in the table.");
            
            alert.showAndWait();
        }
    }
}
