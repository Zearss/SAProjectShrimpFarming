import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class SizeController {
    Account account;
    public void setAccount(Account account) {
        this.account = account;
    }
    @FXML
    private ComboBox<String> Sexbox,Sizebox;
    @FXML
    Pane scenePane;
    @FXML
    TextField Weightfield;
    @FXML
    public void initialize() throws URISyntaxException {
        scenePane.setStyle("-fx-background-color: Pink");
        Sexbox.getItems().setAll("เพศผู้","เพศเมีย");
    }
    @FXML
    public void chooseSex(ActionEvent event) {
        if (Sexbox.getValue().equals("เพศผู้")) {
            Sizebox.getItems().setAll("6-8","9-10","11-12","13-14","15-16","17-18","19-20");
        }
        else{
            Sizebox.getItems().setAll("20-24","25-29","30-34","35-39","40-50");
        }
    }
    @FXML
    public void endBtnAction(ActionEvent event) throws IOException {
        if(Sexbox.getValue().equals("เพศผู้") ){
            if(Sizebox.getValue().equals("6-8")){
                int total;
                total=Integer.parseInt(Weightfield.getText())*450;
            }
            else if(Sizebox.getValue().equals("9-10")){
                int total;
                total=Integer.parseInt(Weightfield.getText())*400;
            }
            else if(Sizebox.getValue().equals("11-12")){
                int total;
                total=Integer.parseInt(Weightfield.getText())*380;
            }
            else if(Sizebox.getValue().equals("13-14")){
                int total;
                total=Integer.parseInt(Weightfield.getText())*360;
            }
            else if(Sizebox.getValue().equals("15-16")){
                int total;
                total=Integer.parseInt(Weightfield.getText())*340;
            }
            else if(Sizebox.getValue().equals("17-18")){
                int total;
                total=Integer.parseInt(Weightfield.getText())*300;
            }
            else if(Sizebox.getValue().equals("19-20")){
                int total;
                total=Integer.parseInt(Weightfield.getText())*280;
            }
        }
        System.out.println(account);
        String alert= "สั่งซื้อสำเร็จ";
        AlertBox.display("Success!",alert);
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("end.fxml"));
        stage.setScene(new Scene(loader.load(),600,400));
        stage.show();
    }


}
