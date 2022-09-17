package Dev_J_140;

import Dev_J_140.GUI.PersonStage;
import Dev_J_140.repo.Repository;
import Dev_J_140.models.User;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import javafx.stage.Stage;

public class MainStage extends Application {
    
    List<User> resultList = new ArrayList<>();
    String enteredUserName;
    String enteredPassword;
    AnchorPane root;
    Label labelWelcom;
    Label labelUserName;
    Label labelPassword;
    Label labelError;
    TextField textFieldUserName;
    PasswordField textFieldPassword;
    
    @Override
    public void start(Stage primaryStage) {
        
        closeApp(primaryStage); 
                
        Font aB_25 = new Font("Arial Bold", 25);
        Font aB_20 = new Font("Arial Bold", 20);
        Font a_20 = new Font("Arial", 20);
        
        labelWelcom = new Label("             Welcom.\nAuthorization required.");
        labelWelcom.setFont(a_20); 
        labelUserName = new Label("User name:");
        labelUserName.setFont(aB_25); 
        labelPassword = new Label("Password:");
        labelPassword.setFont(aB_25); 
        labelError = new Label("Authorization failed. "
                + "Unknown username or the password is incorrect.\n"
                + "                     "
                + "                  Click \"Clear\" and try again.");                                
        labelError.setFont(new Font("Arial Bold", 15));
        labelError.setTextFill(Paint.valueOf("Red")); 
        labelError.setVisible(false); 
        textFieldUserName = new TextField();
        textFieldUserName.setMinWidth(260);
        textFieldUserName.setFont(a_20);
        textFieldPassword = new PasswordField();
        textFieldPassword.setMinWidth(260);
        textFieldPassword.setFont(a_20);
        textFieldPassword.setOnKeyPressed(eh -> {
        if (eh.getCode().equals(KeyCode.ENTER)) 
            signInAction();
        });
        Button signIn = new Button("Sign in");
        Button clear = new Button("Clear");
        signIn.setFont(aB_20);
        clear.setFont(aB_20);
        signIn.setOnAction(aE -> signInAction());

        clear.setOnAction(aE -> {textFieldPassword.setText("");
                                 textFieldUserName.setText("");
                                 labelError.setVisible(false);                                  
        });                  
        AnchorPane.setTopAnchor(labelWelcom, 50.0);
        AnchorPane.setLeftAnchor(labelWelcom, 230.0);
        
        AnchorPane.setTopAnchor(labelUserName, 150.0);
        AnchorPane.setLeftAnchor(labelUserName, 100.0);
        
        AnchorPane.setTopAnchor(textFieldUserName, 150.0);
        AnchorPane.setLeftAnchor(textFieldUserName, 250.0);
        
        AnchorPane.setTopAnchor(textFieldPassword, 200.0);
        AnchorPane.setLeftAnchor(textFieldPassword, 250.0);
        
        AnchorPane.setTopAnchor(labelPassword, 200.0);
        AnchorPane.setLeftAnchor(labelPassword, 110.0);
        
        AnchorPane.setTopAnchor(clear, 175.0);
        AnchorPane.setLeftAnchor(clear, 530.0);
        
        AnchorPane.setTopAnchor(signIn, 250.0);
        AnchorPane.setLeftAnchor(signIn, 415.0);
        
        AnchorPane.setTopAnchor(labelError, 330.0);
        AnchorPane.setLeftAnchor(labelError, 100.0);
        
        root = new AnchorPane(); 
        root.setBackground(Background.EMPTY);
        root.getChildren().addAll(labelWelcom, labelUserName, 
                labelPassword, textFieldUserName, textFieldPassword, 
                clear, labelError, signIn);        
        Scene scene = new Scene(root, 680, 400);              
        primaryStage.setTitle("Authorization window");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void signInAction(){
        
        enteredUserName = textFieldUserName.getText();
        enteredPassword = textFieldPassword.getText();
        resultList = new Repository().getUsers(enteredUserName);
        boolean goodPassword = false;
        for(User user : resultList){
            goodPassword = user.getPassword().equals(enteredPassword);
            if(goodPassword)
               break;
            }
            if(goodPassword) {
                new PersonStage().show();
             }
             else
                labelError.setVisible(true);          
    } 
    private void closeApp(Stage stage){
        
        stage.setOnCloseRequest(evt -> {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm Close");
        alert.setHeaderText("Close the app? Are you sure?");
        alert.showAndWait().ifPresent(response -> {
        if (response == ButtonType.OK)
            System.exit(0);
        else evt.consume();
            });      
        });       
    }
    public static void main(String[] args) {
        launch(args);
    }  
}