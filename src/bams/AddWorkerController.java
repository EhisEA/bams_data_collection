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
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AddWorkerController implements Initializable {

    
    
    @FXML
     TextField name;
    @FXML
     TextField password;
   
    Connection con;
      private void conn() throws SQLException, ClassNotFoundException{
       
            String JDBC_DRIVER = "org.apache.debby.jdbc.EmbeddedDriver";
         String DB_URL = "jdbc:derby://localhost:1527/bams";
         String DB_USERNAME = "emmy";
         String DB_PASSWORD = "emmy";
            con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            
      }
      
    @FXML
    private void addDataButton(ActionEvent event) {
      try{
          System.out.println("in there");
          conn();
        String sql = "insert into worker values(?,?)";
        PreparedStatement pst= con.prepareStatement(sql);
        pst.setString(1, name.getText() );
        pst.setString(2, password.getText() );
        name.setText("");password.setText("");
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
       
    }    
    
}
