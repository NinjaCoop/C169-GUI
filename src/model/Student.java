/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

import javafx.beans.property.*;

/**
 *
 * @author sinjincooper
 */
public class Student {
    
    private final StringProperty id;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty email;
    private final IntegerProperty age;
    //private final StringProperty grades;
    
    /*public Student() {
    }*/
    
    public Student(String id, String firstName, String lastName, String email, int age) {
        this.id = new SimpleStringProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.email = new SimpleStringProperty(email);
        this.age = new SimpleIntegerProperty(age);
        //this.grades = new SimpleStringProperty(grades);
    }
    
    public String getId() { return id.get(); }
    public String getFirstName() { return firstName.get(); }
    public String getLastName() { return lastName.get(); }
    public String getEmail() { return email.get(); }
    public int getAge() { return age.get(); }
    //public String getId() { return grades.get(); }
    
    public void setId(String id) { this.id.set(id); }
    public void setFirstName(String firstName) { this.firstName.set(firstName); }
    public void setLastName(String lastName) { this.lastName.set(lastName); }
    public void setEmail(String email) { this.email.set(email); }
    public void setAge(int age) { this.age.set(age); }
    //public void setId(int[] grades) { this.grades.set(grades); }
    
    public StringProperty idProperty() { return id; }
    public StringProperty firstNameProperty() { return firstName; }
    public StringProperty lastNameProperty() { return lastName; }
    public StringProperty emailProperty() { return email; }
    public IntegerProperty ageProperty() { return age; }
    //public StringProperty gradesProperty() { return grades; }
}
