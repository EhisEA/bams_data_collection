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
public class ViewInfoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private TableView<User> table;
    @FXML private TableColumn<User, String> name;
    @FXML private TableColumn<User, String> phone;
    @FXML private TableColumn<User, String> address;
    @FXML private TableColumn<User, String> email;
     public ObservableList<User> data = FXCollections.observableArrayList();
     
     
     
      private void arrangeTable(){
        name.setCellValueFactory(new PropertyValueFactory<User, String>("name"));;
        phone.setCellValueFactory(new PropertyValueFactory<User, String>("phone"));
        address.setCellValueFactory(new PropertyValueFactory<User, String>("address"));
        email.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        table.setItems(data);  
    }
      Connection con;
      private void conn() throws SQLException, ClassNotFoundException{
       Class.forName("org.sqlite.JDBC");
       con= DriverManager.getConnection("jdbc:sqlite:bams.db");
      }
      
      
      
      private void addData(){
        
         try{conn();
        ResultSet rs ;
        String sql = "select * from attendant";
        Statement pst= con.createStatement();
        rs=pst.executeQuery(sql);
        
        
        while(rs.next()){
            System.out.println(rs.getRow());    
            data.add(new User(rs.getString("name"), rs.getString("phone"), rs.getString("address"), rs.getString("email")));
              
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
