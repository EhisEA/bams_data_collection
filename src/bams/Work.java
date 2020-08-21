/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bams;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author EMMANUEL AYEMERE
 */
public class Work {
     private final SimpleStringProperty name;
    private final SimpleStringProperty password;
    
    public Work(String name,String password){
        this.name= new SimpleStringProperty(name);
        this.password= new SimpleStringProperty(password);
        
    }

    public String getName() {
        return name.get();
    }
    
      public String getPassword() {
        return password.get();
    }

    
}
