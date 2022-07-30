package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.Database;
import db.DatabaseMeal;
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
import mode.Meals;
import mode.Rooms;
import view.tm.MealTM;
import view.tm.RoomTM;

import java.io.IOException;
import java.util.Optional;

public class MealsTableController {
    public AnchorPane mealsContext;

    public TableView<MealTM> tblMeals;
    public TableColumn colRmNum;
    public TableColumn colMealType;
    public TableColumn colMealTime;
    public TableColumn colPortion;
    public TableColumn colPrice;
    public TableColumn colOption;
    public TableColumn colMealStatus;

    public JFXTextField txtRnum;
    public JFXTextField txtMlTime;
    public JFXTextField txtPortion;
    public JFXTextField txtPrice;
    public JFXTextField txtMLType;
    public JFXButton btnSaveMeal;
    public TextField searchMalabar;

    public void initialize(){

        colRmNum.setCellValueFactory(new PropertyValueFactory("roomNum"));
        colMealType.setCellValueFactory(new PropertyValueFactory("mealType"));
        colMealTime.setCellValueFactory(new PropertyValueFactory("mealTime"));
        colPortion.setCellValueFactory(new PropertyValueFactory("portion"));
        colPrice.setCellValueFactory(new PropertyValueFactory("price"));
        colOption.setCellValueFactory(new PropertyValueFactory("btn"));
        colMealStatus.setCellValueFactory(new PropertyValueFactory("box"));
        loadAllMeals();

        tblMeals.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if(newValue!=null){
                setData(newValue);
            }
        });



    }
    private void loadAllMeals() {
        ObservableList<MealTM> obList = FXCollections.observableArrayList();

        for (Meals m: DatabaseMeal.mealsTable
             ) {
            CheckBox box = new CheckBox();
            Button btn=new Button("Delete");

           MealTM tm= new MealTM(m.getRoomNum(), m.getMealType(),m.getMealTime(),m.getPortion(),m.getPrice(),btn,box);

            obList.add(tm);

            btn.setOnAction((e)->{

                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You sure ?",
                        ButtonType.YES,ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();

                if(buttonType.get().equals(ButtonType.YES)){
                    //delete to alert action
                    DatabaseMeal.mealsTable.remove(m);
                    obList.remove(tm);
                }

            });
        }
        tblMeals.setItems(obList);

////////////////////////////////////////////////////////////////////////////////////////////////////////
        FilteredList<MealTM> filterData = new FilteredList<MealTM>(obList, b -> true);

        searchMalabar.textProperty().addListener((observable, oldValue, newValue) -> {
            filterData.setPredicate(Meals -> {
                if (newValue == null || newValue.isEmpty()) {

                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                String portion = String.valueOf(Meals.getPortion());
                String price = String.valueOf(Meals.getPrice());

                if (Meals.getRoomNum().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (Meals.getMealType().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;
                else if (Meals.getMealTime().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if (portion.toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else if (price.toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else
                    return false;
            });
        });
        SortedList<MealTM> sortedData = new SortedList<>(filterData);

        sortedData.comparatorProperty().bind(tblMeals.comparatorProperty());

        tblMeals.setItems(sortedData);

////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) mealsContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AdminDashBoard.fxml"))));
        stage.centerOnScreen();
    }
    public void saveMealDetailsOnAction(ActionEvent actionEvent) {

        if(btnSaveMeal.getText().equals("SAVE DETAILS")){

            Meals m1=new Meals(
                    txtRnum.getText(),
                    txtMLType.getText(),
                    txtMlTime.getText(),
                    Integer.parseInt(txtPortion.getText()),
                    Double.parseDouble(txtPrice.getText())
            );
            DatabaseMeal.mealsTable.add(m1);
            loadAllMeals();

        }else{

            for(Meals ml: DatabaseMeal.mealsTable){
                if(ml.getRoomNum().equals(txtRnum.getText())){
                    ml.setMealType(txtMLType.getText());
                    ml.setMealTime(txtMlTime.getText());
                    ml.setPortion(Integer.parseInt(txtPortion.getText()));
                    ml.setPrice(Double.parseDouble(txtPrice.getText()));


                    loadAllMeals();
                    return;
                }
            }
        }
    }

    private void setData(MealTM tt) {
        btnSaveMeal.setText("UPDATE DETAILS");

        txtRnum.setText(tt.getRoomNum());
        txtMLType.setText(tt.getMealType());
        txtMlTime.setText(tt.getMealTime());
        txtPortion.setText(String.valueOf(tt.getPortion()));
        txtPrice.setText(String.valueOf(tt.getPrice()));
    }

    public void addNewMealOnAction(ActionEvent actionEvent) {
        btnSaveMeal.setText("SAVE DETAILS");
    }
}