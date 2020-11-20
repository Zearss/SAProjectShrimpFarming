import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class ManuController {
    Account account;
    public void setAccount(Account account) {
        this.account = account;
    }
    @FXML
    Pane scenePane;
    @FXML
    public void initialize() throws URISyntaxException {
        scenePane.setStyle("-fx-background-color: Pink");
    }
    @FXML
    public void sizeBtnAction(ActionEvent event) throws IOException {
        System.out.println(account);
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("size.fxml"));
        stage.setScene(new Scene(loader.load(),600,400));
        SizeController SizeController = loader.getController();
        SizeController.setAccount(account);
        stage.show();
    }
}
