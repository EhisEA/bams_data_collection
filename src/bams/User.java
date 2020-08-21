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
public class User {
    private final SimpleStringProperty name;
    private final SimpleStringProperty phone;
    private final SimpleStringProperty address;
    private final SimpleStringProperty email;
    
    public User(String name, String phone, String address, String email){
        this.name= new SimpleStringProperty(name);
        this.phone= new SimpleStringProperty(phone);
        this.address= new SimpleStringProperty(address);
        this.email= new SimpleStringProperty(email);
    }

    public String getName() {
        return name.get();
    }
    
      public String getPhone() {
        return phone.get();
    }

    public String getAddress() {
        return address.get();
    }

    public String getEmail() {
        return email.get();
    }
    
    
}
