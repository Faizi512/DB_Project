
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

public class Q8Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    ObservableList<Table> list = FXCollections.observableArrayList();
    @FXML
    private TableView<Table> table;
    @FXML

    private TableColumn<Table, String> name;
    @FXML
    private TableColumn<Table, Integer> Members;
    @FXML
    private TableColumn<Table, Integer> total;

    Statement st;
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            st = new DataBase_Connection().getStatement();
            String q = "select cinema.Name as Cinema_Name,count(distinct m.Client_ID) as Members ,sum( t.Price)as Total_SUM\n"
                    + "from MEMBER m,CLIENT c,TICKET t,CINEMA cinema\n"
                    + "where m.Client_ID=c.Client_ID and m.Client_ID=t.Client_Id \n"
                    + "group by cinema.Name\n"
                    + "order by cinema.Name,sum(t.Price) desc";
            ResultSet rs = st.executeQuery(q);
            while (rs.next()) {
                list.add(new Table(rs.getString(1), rs.getInt(2), rs.getInt(3)));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        name.setCellValueFactory(new PropertyValueFactory<Table, String>("Name1"));
        Members.setCellValueFactory(new PropertyValueFactory<Table, Integer>("Members"));
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
