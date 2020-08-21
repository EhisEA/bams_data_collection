/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bams;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author EMMANUEL AYEMERE
 */
public class CollectInfoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
     TextField name;
    @FXML
     TextField phone;
    @FXML
     TextField address;
    @FXML
     TextField email;
   
    Connection con;
      private void conn() throws SQLException, ClassNotFoundException{
       Class.forName("org.sqlite.JDBC");
       con= DriverManager.getConnection("jdbc:sqlite:bams.db");
      }
      
    @FXML
    private void addDataButton(ActionEvent event) {
      try{conn();
        String sql = "insert into attendant values(?,?,?,?)";
        PreparedStatement pst= con.prepareStatement(sql);
        pst.setString(1, name.getText() );
        pst.setString(2, phone.getText() );
        pst.setString(3, address.getText());
        pst.setString(4, email.getText());
        
        pst.executeUpdate();
        }
        catch(Exception e){
           JFrame j = new JFrame();
           JOptionPane.showMessageDialog(j, e); 
        }
     
    }
    
    @FXML
     private void back(ActionEvent event) throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        Scene sce= new Scene(root);
        Stage  stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sce);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
