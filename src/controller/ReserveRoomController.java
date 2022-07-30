package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.DatabaseReservation;
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
import mode.Customer;
import view.tm.CustomerTM;


import java.io.IOException;
import java.util.Optional;

public class ReserveRoomController {
    public AnchorPane reserveRoomContextt;

    public TableView<CustomerTM> tblCustomer;

    public TableColumn colCusName;
    public TableColumn colCusNic;
    public TableColumn colTPNum;
    public TableColumn colEmail;
    public TableColumn colAddress;
    public TableColumn colRoomNum;
    public TableColumn colRoomAvailable;
    public TableColumn colMealPlan;
    public TableColumn colCancelOption;
    
    public JFXTextField txtCusName;
    public JFXTextField txtCusNic;
    public JFXTextField txtTpNum;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtRoomNum;
    public JFXButton btnSaveDetails;
    public TextField searchCustomer;


    public void initialize(){

        colCusName.setCellValueFactory(new PropertyValueFactory("name"));
        colCusNic.setCellValueFactory(new PropertyValueFactory("id"));
        colTPNum.setCellValueFactory(new PropertyValueFactory("tpNum"));
        colEmail.setCellValueFactory(new PropertyValueFactory("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colRoomNum.setCellValueFactory(new PropertyValueFactory("roomNum"));
        colRoomAvailable.setCellValueFactory(new PropertyValueFactory("availableBox"));
        colMealPlan.setCellValueFactory(new PropertyValueFactory("mealBox"));
        colCancelOption.setCellValueFactory(new PropertyValueFactory("btn"));

        loadAllCustomer();


        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if(newValue!=null){
                setData(newValue);
            }

        });

    }

    private void setData(CustomerTM tm) {
        btnSaveDetails.setText("UPDATE DETAILS");
        txtCusName.setText(tm.getName());
        txtCusNic.setText(tm.getId());
        txtTpNum.setText(tm.getTpNum());
        txtEmail.setText(tm.getEmail());
        txtAddress.setText(tm.getAddress());
        txtRoomNum.setText(tm.getRoomNum());


    }

    private void loadAllCustomer() {
        ObservableList<CustomerTM> obList= FXCollections.observableArrayList();


        for (Customer c: DatabaseReservation.customerTable) {

            ComboBox availableBox= new ComboBox();

            availableBox.getItems().add("AVAILABLE ROOM");
            availableBox.getItems().add("NOT AVAILABLE ROOM ");



            ComboBox mealBox= new ComboBox();
            mealBox.getItems().add("FRENCH");
            mealBox.getItems().add("CHINESE");
            mealBox.getItems().add("LOCAL");

            Button btn =new Button("CANCEL REQUEST");

            CustomerTM tm=new CustomerTM(c.getName(),c.getId(),c.getTpNum(),c.getEmail()
                    ,c.getAddress(),c.getRoomNum(),availableBox,mealBox,btn);
            obList.add(tm);

            btn.setOnAction((e)->{

                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You sure ?",
                        ButtonType.YES,ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();

                if(buttonType.get().equals(ButtonType.YES)){
                    //delete to alert action
                    DatabaseReservation.customerTable.remove(c);
                    obList.remove(tm);
                }

            });


        }
         tblCustomer.setItems(obList);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        FilteredList<CustomerTM> filterData = new FilteredList<CustomerTM>(obList, b -> true);

        searchCustomer.textProperty().addListener((observable, oldValue, newValue) -> {
            filterData.setPredicate(Customer-> {
                if (newValue == null || newValue.isEmpty()) {

                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();


                if (Customer.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (Customer.getId().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;
                else if (Customer.getTpNum().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if (Customer.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if (Customer.getAddress().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if (Customer.getRoomNum().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }

                else
                    return false;
            });
        });
        SortedList<CustomerTM> sortedData = new SortedList<>(filterData);

        sortedData.comparatorProperty().bind(tblCustomer.comparatorProperty());

        tblCustomer.setItems(sortedData);

////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }


    public void backToHomeRecepOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) reserveRoomContextt.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReceptionistDashBoard.fxml"))));
        stage.centerOnScreen();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {

        if(btnSaveDetails.getText().equals("SAVE DETAILS")){
            Customer c1 = new Customer(
                    txtCusName.getText(),
                    txtCusNic.getText(),
                    txtTpNum.getText(),
                    txtEmail.getText(),
                    txtAddress.getText(),
                    txtRoomNum.getText()
            );
            DatabaseReservation.customerTable.add(c1);
            loadAllCustomer();

        }else{

            for (Customer tm:DatabaseReservation.customerTable) {

              if(tm.getName().equals(txtCusName.getText())){

                  tm.setId(txtCusNic.getText());
                  tm.setTpNum(txtTpNum.getText());
                  tm.setEmail(txtEmail.getText());
                  tm.setAddress(txtAddress.getText());
                  tm.setRoomNum(txtRoomNum.getText());

                  loadAllCustomer();
                  return;
              }
            }
        }

    }

    public void btnAddNewCustomerOnAction(ActionEvent actionEvent) {
        btnSaveDetails.setText("SAVE DETAILS");
    }
}
