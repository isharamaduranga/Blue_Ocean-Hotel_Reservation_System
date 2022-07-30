package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {
    public TextField txtUserName;
    public PasswordField pwdPassword;
    public Button adminBtn;
    public Button receptionBtn;
    public AnchorPane loginformcontext;

    int attemptsLogAdmin=0;
    int attemptsLogReceptionist=0;

    public void LogInAdminOnAction(ActionEvent actionEvent) throws IOException {

        if(adminBtn.getText().equals("LOG IN ADMIN")) {

            attemptsLogAdmin++;
            if (attemptsLogAdmin < 5) {  // attempts calculate

                if (txtUserName.getText().equals("admin") & pwdPassword.getText().equals("1234")) {

                    Stage stage = (Stage) loginformcontext.getScene().getWindow();
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AdminDashBoard.fxml"))));

                } else {
                    // error warning information
                    new Alert(Alert.AlertType.WARNING, "Try Again !").show();
                }

            } else {
              //  number of wrong input visible false option
                txtUserName.setVisible(false);
                pwdPassword.setVisible(false);
            }

        }else{}

        if(adminBtn.getText().equals("LOG IN  RECEPTION")) {

            attemptsLogReceptionist++;
            if (attemptsLogReceptionist < 5) {       // attempts calculate

                if (txtUserName.getText().equals("recep") & pwdPassword.getText().equals("1234")) {

                    // build new Scene

                    Stage stage = (Stage) loginformcontext.getScene().getWindow();
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReceptionistDashBoard.fxml"))));



                } else {
                    // error warning information
                    new Alert(Alert.AlertType.WARNING, "Try Again !").show();
                }
            } else {  //  number of wrong input visible false option
                txtUserName.setVisible(false);
                pwdPassword.setVisible(false);
            }

        }else{}

    }

    public void LogInReceptionistOnAction(ActionEvent actionEvent) throws IOException {
        // receptionist button catch that name and set admin get text
        String temp =adminBtn.getText();
        adminBtn.setText(receptionBtn.getText());
            receptionBtn.setText(temp);

    }

}
