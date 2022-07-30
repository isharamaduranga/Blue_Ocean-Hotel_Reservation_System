package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class AdminDashBoardController  {


    public AnchorPane dashBoardContext;


    public void openWindowRoomOnAction(ActionEvent actionEvent) throws IOException {

        setUi("roomTable");

    }

    public void openWindowMealOnAction(ActionEvent actionEvent) throws IOException {

        setUi("mealsTable");

    }

    public void openWindowIncomeOnAction(ActionEvent actionEvent) throws IOException {

        setUi("incomeTable");
    }
    private void setUi (String location) throws IOException {
        Stage stage = (Stage) dashBoardContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }


    public void logOutHomeOnAction(ActionEvent actionEvent) throws IOException {

        Alert alert =  new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure You Want To Log Out?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get().equals(ButtonType.YES)){
            Stage stage = (Stage) dashBoardContext.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"))));

        }else {}
    }
}

