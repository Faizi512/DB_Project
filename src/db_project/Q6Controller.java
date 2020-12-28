/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_project;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

/**
 * FXML Controller class
 *
 * @author S-R-H Khan
 */
public class Q6Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    ObservableList<Table> list = FXCollections.observableArrayList();
    @FXML
    private TableView<Table> table;
    @FXML
    private TableColumn<Table, String> id;
    @FXML
    private TableColumn<Table, String> name;
    @FXML
    private TableColumn<Table, String> other;
    @FXML
    private TableColumn<Table, Integer> total;
    Statement st;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            st = new DataBase_Connection().getStatement();
            String q = "select top 1 m.Movie_ID,m.Movie_Name,m.Director,sum(t.Price)as Total_SUM\n"
                    + "from MOVIE m,TICKET t\n"
                    + "where m.Movie_ID=t.Movie_ID\n"
                    + "group by m.Movie_ID,m.Movie_Name,m.Director\n"
                    + "order by sum(t.Price) desc";
            ResultSet rs = st.executeQuery(q);
            while (rs.next()) {
                list.add(new Table(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        id.setCellValueFactory(new PropertyValueFactory<Table, String>("ID_Ad"));
        name.setCellValueFactory(new PropertyValueFactory<Table, String>("Name1"));
        other.setCellValueFactory(new PropertyValueFactory<Table, String>("other"));
        total.setCellValueFactory(new PropertyValueFactory<Table, Integer>("Total_SUM"));
        table.setItems(list);
    }
    
    public void back(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.resizableProperty().setValue(Boolean.FALSE);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
