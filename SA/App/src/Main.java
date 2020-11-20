import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Shrimp Sale");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
/*    public static void main(String[] args) {
        launch(args);
    }
    public Connection getConnection() throws Exception {
        Connection connection = null;         try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","");
            System.out.println("Connected");
        }
        catch (Exception e){
            System.out.println(e);
        }         return connection;
    }
    public void createTable() throws Exception{
        try {
            Connection connection = getConnection();
            PreparedStatement create = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS Persons (PersonID int,LastName varchar(255),FirstName varchar(255),Address varchar(255),City varchar(255));");
            create.executeUpdate();
        }
        catch (Exception e){
            System.out.print(e);
        }
    } */
}