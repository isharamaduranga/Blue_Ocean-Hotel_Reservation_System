package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mode.Rooms;
import view.tm.RoomTM;

import java.io.IOException;
import java.util.Optional;

public class RoomTableController {
    public AnchorPane roomContext;

    public TableView<RoomTM> tblRooms;
    public TableColumn rmNoCol;
    public TableColumn rmTypCol;
    public TableColumn cNicCol;
    public TableColumn cNameCol;
    public TableColumn dateCol;
    public TableColumn timeCol;
    public TableColumn optionCol;

    public JFXTextField txtRoomType;
    public JFXTextField txtDate;
    public JFXTextField txtCusName;
    public JFXTextField txuCusNic;
    public JFXTextField txtRoomNo;
    public JFXTextField txtTime;
    public JFXButton btnSave;
    public TextField searchAdminRoom;

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) roomContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AdminDashBoard.fxml"))));
        stage.centerOnScreen();
    }

public void initialize(){

        rmNoCol.setCellValueFactory(new PropertyValueFactory("roomNo"));
        rmTypCol.setCellValueFactory(new PropertyValueFactory("roomType"));
        cNicCol.setCellValueFactory(new PropertyValueFactory("cusNic"));
        cNameCol.setCellValueFactory(new PropertyValueFactory("cusName"));
        dateCol.setCellValueFactory(new PropertyValueFactory("date"));
        timeCol.setCellValueFactory(new PropertyValueFactory("time"));
        optionCol.setCellValueFactory(new PropertyValueFactory("btn"));


        loadAllRooms();

        tblRooms.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{

            if(newValue!=null){
                setData(newValue);
            }

                });
}
    private void setData(RoomTM tm) {

        btnSave.setText("UPDATE CUSTOMER");

        txtRoomNo.setText(tm.getRoomNo());
        txtRoomType.setText(tm.getRoomType());
        txuCusNic.setText(tm.getCusNic());
        txtCusName.setText(tm.getCusName());
        txtDate.setText(tm.getDate());
        txtTime.setText(tm.getTime());


    }

    private void loadAllRooms() {
        ObservableList<RoomTM> obList = FXCollections.observableArrayList();

        for(Rooms r: Database.roomsTable){

            Button btn = new Button("Delete");
            RoomTM tm = new RoomTM(r.getRoomNo(),r.getRoomType(),r.getCusNic(),r.getCusName(),r.getDate(),r.getTime(),btn);
            obList.add(tm);
            btn.setOnAction((e)->{

               Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You sure ?",
                       ButtonType.YES,ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();

                if(buttonType.get().equals(ButtonType.YES)){
                    //delete to alert action
                    Database.roomsTable.remove(r);
                    obList.remove(tm);
                }
            });
        }


        tblRooms.setItems(obList);

////////////////////////////////////////////////////////////////////////////////////////////////////
        FilteredList<RoomTM> filterData = new FilteredList<RoomTM>(obList, b -> true);

        searchAdminRoom.textProperty().addListener((observable, oldValue, newValue) -> {
            filterData.setPredicate(Rooms -> {
                if (newValue == null || newValue.isEmpty()) {

                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();


                if (Rooms.getRoomNo().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (Rooms.getRoomType().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;
                else if (Rooms.getCusNic().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if (Rooms.getCusName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else
                    return false;

            });
        });

        SortedList<RoomTM> sortedData = new SortedList<>(filterData);

        sortedData.comparatorProperty().bind(tblRooms.comparatorProperty());

        tblRooms.setItems(sortedData);


        ////////////////////////////////////////////////////////////////////////////////

    }

    public void saveOnAction(ActionEvent actionEvent) {

        if(btnSave.getText().equals("SAVE DETAILS")){

            Rooms r1=new Rooms(
                    txtRoomNo.getText(),
                    txtRoomType.getText(),
                    txuCusNic.getText(),
                    txtCusName.getText(),
                    txtDate.getText(),
                    txtTime.getText()
            );
            Database.roomsTable.add(r1);
            loadAllRooms();

        }else{

            for(Rooms tm: Database.roomsTable){
                if(tm.getRoomNo().equals(txtRoomNo.getText())){
                    tm.setRoomType(txtRoomType.getText());
                    tm.setCusNic(txuCusNic.getText());
                    tm.setCusName(txtCusName.getText());
                    tm.setDate(txtDate.getText());
                    tm.setTime(txtTime.getText());

                    loadAllRooms();
                    return;
                }
            }
        }
    }

    public void btnNewRoom(ActionEvent actionEvent) {

        btnSave.setText("SAVE DETAILS");

    }
}
