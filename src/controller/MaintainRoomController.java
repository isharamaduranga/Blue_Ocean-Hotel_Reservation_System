package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.DatabaseMaintain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mode.cleaner;
import view.tm.CleanerTM;


import java.io.IOException;

public class MaintainRoomController {
    public AnchorPane maintainRoomContext;

    public TableView<CleanerTM>tblMaintain;
    public TableColumn colRoomNum;
    public TableColumn colCleanTime;
    public TableColumn colRmAvailable;
    public TableColumn colCleanStatus;

    public JFXTextField txtTime;
    public JFXButton btnSave;


    public void initialize(){

        colRoomNum.setCellValueFactory(new PropertyValueFactory("roomNum"));
        colCleanTime.setCellValueFactory(new PropertyValueFactory("time"));
        colRmAvailable.setCellValueFactory(new PropertyValueFactory("availability"));
        colCleanStatus.setCellValueFactory(new PropertyValueFactory("cleanStatus"));

        tblMaintain.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {


            if(newValue!=null){
                setData(newValue);
            }
        });

        loadAllCleaners();
    }

    private void setData(CleanerTM tm) {
        btnSave.setText("UPDATE TIME");
        txtTime.setText(tm.getTime());
    }

    private void loadAllCleaners() {


        ObservableList<CleanerTM> obList = FXCollections.observableArrayList();
        for (cleaner c: DatabaseMaintain.cleanTable) {

            ComboBox comBox = new ComboBox();

            comBox.getItems().add("AVAILABLE ROOM");
            comBox.getItems().add("NOT AVAILABLE ROOM ");

            CheckBox chkBox = new CheckBox();

            chkBox.setText("CLEANED");

            CleanerTM tm= new CleanerTM(c.getRoomNum(),c.getTime(),comBox,chkBox);
            obList.add(tm);
            
        }
        tblMaintain.setItems(obList);

        
    }


    public void backToHomeRecepOnAction(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) maintainRoomContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReceptionistDashBoard.fxml"))));
        stage.centerOnScreen();

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {

      /*  if(btnSave.getText().equals("UPDATE TIME")){
            cleaner c1 =new cleaner(
                    txtTime.getText()

            );
            DatabaseMaintain.cleanTable.add(c1);
            loadAllCleaners();
        }*/



         if(btnSave.getText().equals("UPDATE TIME")){
            for (cleaner tm:DatabaseMaintain.cleanTable
                 ) {
                if (tm.getTime().equals(txtTime.getText())) {
                    tm.setTime(txtTime.getText());
                    //loadAllCleaners();

                }
            }
            }
        }


    public void addTimeOnAction(ActionEvent actionEvent) {

        btnSave.setText("SAVE TIME");
    }
}
