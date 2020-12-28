package db_project;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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

public class Q9Controller implements Initializable {

    ObservableList<Table> list = FXCollections.observableArrayList();
    ObservableList<Table> list1 = FXCollections.observableArrayList();
    @FXML
    private TableView<Table> table;
    @FXML

    private TableColumn<Table, Integer> total;

    Statement st;
    @FXML
    private TableColumn<Table, String> Members;
    @FXML
    private TableView<Table> table1;
    @FXML
    private TableColumn<Table, String> Members1;
    @FXML
    private TableColumn<Table, Integer> total1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            st = new DataBase_Connection().getStatement();
            String q = "select MONTH(Date_)as month,sum(price)as sum \n"
                    + "from TICKET\n"
                    + "group by MONTH(Date_)\n"
                    + "order by MONTH(Date_)";
            ResultSet rs = st.executeQuery(q);
            while (rs.next()) {
                list.add(new Table(rs.getString(1), rs.getInt(2)));
            }

            Members.setCellValueFactory(new PropertyValueFactory<Table, String>("Name1"));
            total.setCellValueFactory(new PropertyValueFactory<Table, Integer>("Total_SUM"));
            table.setItems(list);
            q = "select year(Date_),sum(price) \n"
                    + "from TICKET\n"
                    + "group by year(Date_)\n"
                    + "order by year(Date_)";

            rs = st.executeQuery(q);
            while (rs.next()) {
                list1.add(new Table(rs.getString(1), rs.getInt(2)));
            }
            Members1.setCellValueFactory(new PropertyValueFactory<Table, String>("Name1"));
            total1.setCellValueFactory(new PropertyValueFactory<Table, Integer>("Total_SUM"));
            table1.setItems(list1);

        } catch (Exception e) {
            System.out.println("ggggggggggggggggggggggggggg");
            System.out.println(e);
        }

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
