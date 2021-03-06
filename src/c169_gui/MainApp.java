/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c169_gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Student;
import view_controller.RosterOverviewController;
import view_controller.StudentEditDialogController;

/**
 *
 * @author sinjincooper
 */
public class MainApp extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("RosterApp");
        
        initRootLayout();
        
        showStudentOverview();
    }
    
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view_contoller/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showStudentOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view_controller/RosterOverview.fxml"));
            AnchorPane rosterOverview = (AnchorPane) loader.load();
            
            rootLayout.setCenter(rosterOverview);
            
            RosterOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    private ObservableList<Student> studentData = FXCollections.observableArrayList();
    
    public MainApp() {
        studentData.add(new Student("1", "John", "Smith", "jSmith@gmail.com", 20));
        studentData.add(new Student("2", "Susan", "Erickson", "sErickson@gmail.com", 19));
        studentData.add(new Student("3", "Jack", "Napoli", "jNapoli@gmail.com", 19));
        studentData.add(new Student("4", "Erin", "Black", "eBlack@gmail.com", 22));
        studentData.add(new Student("5", "Sinjin", "Cooper", "sCooper@gmail.com", 28));
    }
    
    public ObservableList<Student> getStudentData() {
        return studentData;
    }
    
    /**
     * Opens a dialog to edit details for the specified student. If the user
     * clicks OK, the changes are saved into the provided student object and 
     * true is returned.
     * 
     * @param student the student object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    
    public boolean showStudentEditDialog(Student student) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view_controller/StudentEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            //Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Student");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            // Set the person into the controller.
            StudentEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setStudent(student);
            
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
