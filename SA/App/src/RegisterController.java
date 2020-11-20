import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegisterController {
    @FXML
    TextField Firstname, Lastname, Password, ConPassword, Username ,Address,Tel;

    List<Account> accounts = new ArrayList<>();
    DataSource data = new DataSource();

    @FXML
    public void initialize() {
        accounts = data.readAccounts();
    }

    @FXML
    public void handleBackBtnOnAction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.setResizable(false);
    }

    @FXML
    public void handleRegisterBtnOnAction(ActionEvent event) throws IOException {
        if (Address.getText().equals("") || Password.getText().equals("") || Lastname.getText().equals("") || Firstname.getText().equals("") || Username.getText().equals("") || Tel.getText().equals("")|| ConPassword.getText().equals("")) {
            AlertBox.display("Alert!", "Information uncompleted!");
            return;
        }
        if (accounts.isEmpty()) {
            if(Password.getText().equals(ConPassword.getText())) {
                data.writeAccount( Firstname.getText(), Lastname.getText(),Username.getText(), Password.getText(), Address.getText(), Tel.getText());
                AlertBox.display("Alert!", "Register Successful!");
                Button b = (Button) event.getSource();
                Stage stage = (Stage) b.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
                stage.setScene(new Scene(loader.load(), 606, 430));
                stage.setResizable(false);
                return;
            }
            else {
                AlertBox.display("Alert!", "confirm password do not match.");
                return;
            }
        }
        boolean registerSuccess = false;
        boolean CheakEmail = true;
        boolean CheakUsername = true;
        String massage = "";

        for (Account a : accounts) {
            if (a.getUsername().equals(Username.getText())) {
                CheakUsername = false;
                break;
            }
        }
        if (CheakUsername && ConPassword.getText().equals(Password.getText())) {
            registerSuccess = true;
        }

        if (registerSuccess) {
            AlertBox.display("Alert!", "Register Successful!");
            data.writeAccount(Firstname.getText(), Lastname.getText(),Username.getText(), Password.getText(), Address.getText(), Tel.getText());
            Button b = (Button) event.getSource();
            Stage stage = (Stage) b.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            stage.setScene(new Scene(loader.load(), 606, 430));
            stage.setResizable(false);
            return;
        } else {
            for (Account a : accounts) {
                if (Username.getText().equals(a.getUsername())) {
                    massage += "   This username is already register ,Please use another username  !   ";
                }
            }


            if (!Password.getText().equals(ConPassword.getText())) {
                massage += "\n" + "   confirm password do not match.  ";
            }
        }
        AlertBox.display("Alert!", massage);
        return;
    }
}

