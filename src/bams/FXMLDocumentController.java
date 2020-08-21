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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author EMMANUEL AYEMERE
 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
    private TextField nameText;
    
    String title;
    
    @FXML
    private TextField idText;
    
    @FXML
    private Label label;
    
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/bookDB";
    private static final String DB_USERNAME = "test";
    private static final String DB_PASSWORD = "test";
    private Connection connection;
    private Statement stmt;
     private static final String CREATE_TABLE = "CREATE TABLE BOOKS "
            + "(bookid VARCHAR(255) PRIMARY KEY, "
            + " booktitle VARCHAR(255), "
            + " bookauthor VARCHAR(255), "
            + " editiondate VARCHAR(255))";
   
     public void openConnection() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("kkkkkk");
            stmt = connection.createStatement();
            System.out.println("njnjn");
            stmt.execute(CREATE_TABLE);
        } catch (Exception ex) {
            System.out.println("ffffgffff");
        }
    }
     public void addBook() {
        try {
            String sql = "INSERT INTO BOOKS (booktitle, bookauthor, editiondate) VALUES ('',"+
           "+ '  ', '')";
            stmt.execute(sql);
        } catch (SQLException ex) {
            System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnn");
        }
    }
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if(nameText.getText().toLowerCase().equals("emmanuel")&& idText.getText().toLowerCase().equals("techhive") ){
            admin(event);
            
            }else if(nameText.getText().toLowerCase().equals("ehis")&& idText.getText().toLowerCase().equals("techhive") ){
            worker(event);
            }
    }
    private void admin(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        Scene sce= new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sce);
        stage.show();  
    }
    
     private void worker(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Allowed.fxml"));
        Scene sce= new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sce);
        stage.show();  
    }
    
    
     @FXML
    private void callViewInfo(ActionEvent event) throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("ViewInfo.fxml"));
        Scene sce= new Scene(root);
        Stage  stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sce);
        stage.show();
    }
    
    @FXML
    private void callViewWorker(ActionEvent event) throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("ViewWorker.fxml"));
        Scene sce= new Scene(root);
        Stage  stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sce);
        stage.show();
    }
    
    @FXML
    private void callCollectInfo(ActionEvent event) throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("CollectInfo.fxml"));
        Scene sce= new Scene(root);
        Stage  stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sce);
        stage.show();
    }
    
    @FXML
    private void callAddWorker(ActionEvent event) throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("AddWorker.fxml"));
        Scene sce= new Scene(root);
        Stage  stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sce);
        stage.show();
    }
    
    
    Connection con;
      private void conn() throws SQLException, ClassNotFoundException{
       Class.forName("org.sqlite.JDBC");
       con= DriverManager.getConnection("jdbc:sqlite:bams.db");
        String sql = "select name from sqlite_master where type='table' and name= 'worker'";
        Statement pst= con.createStatement();
       
        ResultSet rs ;
        rs=pst.executeQuery(sql);
        if(!rs.next()){
            System.out.println("setting up your database...");
            String sql3 = "create table worker(name varchar(100), password varchar(100))";
             Statement pst2= con.createStatement();
             pst2.execute(sql3);
             
             
         String sql4 = "insert into worker values(?,?)";
        PreparedStatement pep= con.prepareStatement(sql4);
        pep.setString(1, "miky" );
        pep.setString(2, "hail" );
        pep.execute();
       
        
        
        PreparedStatement pep2= con.prepareStatement(sql4);
        pep2.setString(1, "white" );
        pep2.setString(2, "snow" );
        pep2.execute();
       con.close();
        }else{
            con.close();
        }
        
      }
      
     private void conn2() throws SQLException, ClassNotFoundException{
       Class.forName("org.sqlite.JDBC");
       con= DriverManager.getConnection("jdbc:sqlite:bams.db");
         String sql = "select name from sqlite_master where type='table' and name= 'attendant'";
        Statement pst= con.createStatement();
       
        ResultSet rs ;
        rs=pst.executeQuery(sql);
        if(!rs.next()){
            System.out.println("setting up your database.....");
            String sql3 = "create table attendant(name varchar(100), phone varchar(30),address varchar(100),email varchar(100))";
             Statement pst2= con.createStatement();
             pst2.execute(sql3);
             
             
         String sql4 = "insert into attendant values(?,?,?,?)";
        PreparedStatement pep= con.prepareStatement(sql4);
        pep.setString(1, "miky" );
        pep.setString(2, "9090909" );
        pep.setString(3, "15, osborn" );
        pep.setString(4, "joker@yo.com" );
        pep.execute();
       
        
        
        PreparedStatement pep2= con.prepareStatement(sql4);
        pep2.setString(1, "bolu" );
        pep2.setString(2, "78172" );
        pep2.setString(3, "40, London" );
        pep2.setString(4, "wale@go.com" );
        pep2.execute();
       con.close();
        }
        else{
            con.close();
        }
      }
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    
}
