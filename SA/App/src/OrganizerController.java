import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class OrganizerController {
    Account account;
    public void setAccount(Account account) {
        this.account = account;
    }
    @FXML
    ImageView jung;
    @FXML
    Pane scenePane;
    @FXML
    public void initialize() throws URISyntaxException{
//        image.setImage(new Image(getClass().getResource("jung.jpg").toURI().toString()));
        scenePane.setStyle("-fx-background-color: #FFEAB4");

    }
    @FXML
    public void manuBtnAction(ActionEvent event) throws IOException{
        System.out.println(account);
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("manu.fxml"));
        stage.setScene(new Scene(loader.load(),620,400));
        ManuController ManuController = loader.getController();
        ManuController.setAccount(account);
        stage.show();
    }
}
