/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Student;

/**
 * FXML Controller class
 *
 * @author sinjincooper
 */
public class StudentEditDialogController {

    @FXML
    private TextField idField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField ageField;
    /*@FXML
    private TextField gradesField;*/
    
    private Stage dialogStage;
    private Student student;
    private boolean okClicked = false;
    
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        // TODO
    }    
    
    //Sets the stage of this dialog.
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    //Sets the student to be edited.
    public void setStudent(Student student) {
        this.student = student;
        
        idField.setText(student.getId());
        firstNameField.setText(student.getFirstName());
        lastNameField.setText(student.getLastName());
        emailField.setText(student.getEmail());
        ageField.setText(Integer.toString(student.getAge()));
        //gradesField.setText(student.getGrades());
    }
    
    public boolean isOkClicked() {
        return okClicked;
    }
    
    //Called when user clicks OK.
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            student.setId(idField.getText());
            student.setFirstName(firstNameField.getText());
            student.setLastName(lastNameField.getText());
            student.setEmail(emailField.getText());
            student.setAge(ageField.getText());
            //student.setGrades(gradesField.getText());
            
            okClicked = true;
            dialogStage.close();
        }
    }
    
    //Called when user clicks Cancel.
    private void handleCancel() {
        dialogStage.close();
    }
    
    //Validation of user input
    private boolean isInputValid() {
        String errorMessage = "";
        
        if (idField.getText() == null || idField.getText().length() == 0) {
            errorMessage += "No valid student ID!\n";
        }
        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (emailField.getText() == null || emailField.getText().length() == 0) {
            errorMessage += "No valid email!\n";
        }
        if (ageField.getText() == null || ageField.getText().length() == 0) {
            errorMessage += "No valid age!\n";
        } else {
            try {
                Integer.parseInt(ageField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid age (must be an integer)!\n";
            }
        }
        /*if (gradesField.getText() == null || gradesField.getText().length() == 0) {
            errorMessage += "No valid Student ID!\n";
        }*/
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            //Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
