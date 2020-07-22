package sample;

import java.net.URL;
import java.util.ResourceBundle;
import java.text.DecimalFormat;

import javafx.css.Match;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

import com.amazon.ion.Timestamp;
import com.sun.javafx.scene.control.IntegerField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.Label;

import javafx.scene.control.cell.PropertyValueFactory;
import sample.pojo.Stroka;

public class Controller {
    ObservableList<Stroka> strokaData= FXCollections.observableArrayList();
    ObservableList<Stroka> strokaData1= FXCollections.observableArrayList();
    private double[][] a = new double[10][2];

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button zapolnit;

    @FXML
    private Button vipolnit;

    @FXML
    private TextField fa;

    @FXML
    private TextField fb;

    @FXML
    private TableView<Stroka> Massiv;

    @FXML
    private TableColumn<Stroka, Double> c1;

    @FXML
    private TableColumn<Stroka, Double> c2;

    @FXML
    private Button onClickMethod;

    @FXML
    private Button Exit_;

    @FXML
    void Ochistka(ActionEvent event) {
        fa.setText("");
        fb.setText("");

    }
    @FXML
    void Close_(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    void rez(ActionEvent event) {
        //DecimalFormat df = new DecimalFormat("###.#");
        Massiv.setItems(strokaData1);
        double[] k = new double[10];
        double sum_k=0;
        boolean f=false;
        double f_a=Double.parseDouble(fa.getText());
        double f_b=Double.parseDouble(fb.getText());
         for (int i = 0; i < 10; i++) {
            sum_k=sum_k+a[i][0];
            if (a[i][0]==0) f=true;
         }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        if ((f_a==0) && (f_b==0)) {
            if (f==true){
                for (int i = 0; i < 10; i++) {
                    a[i][1] = Math.sqrt((Math.cos(a[i][0]) * Math.cos(a[i][0])) / ((f_a * f_a + f_b * f_b) - Math.sin(a[i][0]))) * sum_k;
                    strokaData1.addAll(new Stroka(a[i][0], a[i][1]));}
                }
                else {
                    alert.setContentText("a и b немогут одновременно быть равными нулю!");
                    alert.showAndWait();
                }
            }
        else {
            for (int i = 0; i < 10; i++) {
            a[i][1] = Math.sqrt((Math.cos(a[i][0]) * Math.cos(a[i][0])) / ((f_a * f_a + f_b * f_b) - Math.sin(a[i][0]))) * sum_k;
            strokaData1.addAll(new Stroka(a[i][0], a[i][1]));}
        }
        }

    @FXML
    void vvod_data(ActionEvent event) {
        //заполняем массив и таблицу случайным образом
        Massiv.setItems(strokaData);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++){
                a[i][j] = (double) (Math.random()*200 - 100);
                }
            a[i][1]=0;
            strokaData.addAll(new Stroka(a[i][0],a[i][1]));
        }
       }
    @FXML
    void initialize() {

        assert Massiv != null : "fx:id=\"Massiv\" was not injected: check your FXML file 'sample.fxml'.";
        assert c1 != null : "fx:id=\"c1\" was not injected: check your FXML file 'sample.fxml'.";
        assert c2 != null : "fx:id=\"c2\" was not injected: check your FXML file 'sample.fxml'.";
        assert fa != null : "fx:id=\"fa\" was not injected: check your FXML file 'sample.fxml'.";
        assert fb != null : "fx:id=\"fb\" was not injected: check your FXML file 'sample.fxml'.";
        assert zapolnit != null : "fx:id=\"zapolnit\" was not injected: check your FXML file 'sample.fxml'.";
        assert vipolnit != null : "fx:id=\"vipolnit\" was not injected: check your FXML file 'sample.fxml'.";
        assert onClickMethod != null : "fx:id=\"onClickMethod\" was not injected: check your FXML file 'sample.fxml'.";
        assert Exit_ != null : "fx:id=\"Exit_\" was not injected: check your FXML file 'sample.fxml'.";
        c1.setCellValueFactory(new PropertyValueFactory<Stroka, Double>("c1"));
        c2.setCellValueFactory(new PropertyValueFactory<Stroka, Double>("c2"));
        Massiv.setItems(strokaData);


    }
}
