import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoginController {
    @FXML
    TextField UserName,PassWord1;
    @FXML
    Button LoginBtn, RegisterBtn,BookingData;
    @FXML
    PasswordField PassWord;

    private String bookingDataPath = "Data/BookingData.csv";
    String Dataline ="";
    List<Account> accounts=new ArrayList<>();
    DataSource data = new DataSource();

    @FXML
    public void initialize() throws IOException {
        accounts = data.readAccounts();
        readFile();
    }
    @FXML
    ImageView icon;
    @FXML
    public void handleLoginBtnOnAction(ActionEvent event) throws IOException {
        boolean found = false;
        Account userFound = null;
        String alert= "Invalid Username or Password!" ;
        System.out.println(UserName.getText()+PassWord.getText());
        for(Account a: accounts){
            if(a.getUsername().equals(UserName.getText())&&a.getPassword().equals(PassWord.getText())){
                found = true;
                userFound = a;
                break;
            }
            else if(!a.getPassword().equals(PassWord.getText())&&UserName.getText().equals(a.getUsername())){
                alert="Password is wrong please try again!";
            }

        }
        if(found){
            Button b = (Button) event.getSource();
            Stage stage =  (Stage) b.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("organizer.fxml"));
            stage.setScene(new Scene(loader.load(), 800, 600));
            OrganizerController OrganizerController = loader.getController();
            OrganizerController.setAccount(userFound);
            stage.setResizable(false);
        }
        else{
            AlertBox.display("Alert!",alert);
            UserName.setText("");
            PassWord.setText("");
            return;
        }
        if(accounts.isEmpty()){
            AlertBox.display("Alert!","Account is empty");
        }
        UserName.setText("");
        PassWord.setText("");
    }

    @FXML
    public void handleRegisterBtnOnAction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage =  (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));
        stage.setScene(new Scene(loader.load(), 600, 430));
        stage.setResizable(false);

    }
    @FXML
    public void handleCSVBtnOnAction(ActionEvent event) {
        GetCSV();
    }
    public void GetCSV() {

        Stage window =new Stage();
        window.setTitle(".CSV");
        window.setMinWidth(400);
        window.setMinHeight(300);
        Label label =new Label();
        label.setText(Dataline);
        label.setTextFill(Paint.valueOf("#ffffff"));
        label.setStyle("-fx-background-color: #0037ff");

        Button closeButton=new Button("Close");
        closeButton.setOnAction(e -> window.close());
        HBox close=new HBox(10);
        VBox layout =new VBox(10);


        layout.getChildren().add(label);
        layout.setAlignment(Pos.TOP_CENTER);

        close.getChildren().add(closeButton);
        close.setAlignment(Pos.BOTTOM_CENTER);

        layout.getChildren().add(close);
        Scene scene=new Scene(layout);
        window.setScene(scene);
        scene.setFill(Paint.valueOf("#0037ff"));
        window.showAndWait();
    }

    public void readFile() throws IOException {
        createFile();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(bookingDataPath));
        String line = bufferedReader.readLine();
        while(line!=null){
            Dataline +=line+"\n";
            line = bufferedReader.readLine();
        }
    }
    public void createFile() throws IOException {
        File directory = new File("Data");
        if(!directory.exists()){
            directory.mkdirs();
        }
        File file = new File(bookingDataPath);
        file.createNewFile();
    }



}
