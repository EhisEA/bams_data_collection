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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author EMMANUEL AYEMERE
 */
public class ViewWorkerController implements Initializable {

    
    
    @FXML private TableView<Work> table;
    @FXML private TableColumn<Work, String> name;
    @FXML private TableColumn<Work, String> password;
     public ObservableList<Work> data = FXCollections.observableArrayList();
     
     
     
      private void arrangeTable(){
        name.setCellValueFactory(new PropertyValueFactory<Work, String>("name"));
        password.setCellValueFactory(new PropertyValueFactory<Work, String>("password"));
        table.setItems(data); 
    }
      Connection con;
      private void conn() throws SQLException, ClassNotFoundException{
           String JDBC_DRIVER = "org.apache.debby.jdbc.ClientDriver";
        Class.forName(JDBC_DRIVER);
           String DB_URL = "jdbc:derby://localhost:1527/bams";
         String DB_USERNAME = "emmy";
         String DB_PASSWORD = "emmy";
            con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
          
      }
      
      
      
      private void addData(){
        
         try{conn();
        ResultSet rs ;
        String sql = "select * from worker";
        Statement pst= con.createStatement();
        rs=pst.executeQuery(sql);
        
        
        while(rs.next()){
                data.add(new Work(rs.getString("name"), rs.getString("password")));
              
            }
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
        addData();
        arrangeTable();
    }    
    
}
