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
import javafx.stage.Stage;
import model.Student;
import view_controller.RosterOverviewController;

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
}
