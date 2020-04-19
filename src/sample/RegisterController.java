package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class RegisterController {

    ArrayList<StandardUser> account = new ArrayList<>();

    @FXML
    private TextField usernameTextfield;

    @FXML
    private TextField passwordTextfield;

    @FXML
    private TextField firstnameTextfield;

    @FXML
    private TextField lastnameTextfield;

    @FXML
    private TextField SSNTextfield;

    @FXML
    private TextField phoneTextfield;

    @FXML
    private TextField emailTextfield;



    @FXML
    private void backButtonOnAction(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    private void registerButtonOnAction(ActionEvent event){
        String username = usernameTextfield.getText();
        String password = passwordTextfield.getText();
        String firstName = firstnameTextfield.getText();
        String lastName = lastnameTextfield.getText();
        String SSN = SSNTextfield.getText();
        String phoneNumber = phoneTextfield.getText();
        //Måste få fram genererat ett random account number!


        try{
            if (Pattern.matches("[a-zA-Z]+", firstName)){
                if (Pattern.matches("[a-zA-Z]+", lastName)){
                    if (Pattern.matches("[0-9]{10}", SSN)){
                        if (Pattern.matches("[0-9]{10}", phoneNumber)){
                            if (Pattern.matches("[a-zA-Z0-9]+",username)){
                                if (Pattern.matches("[a-zA-Z0-9]{8,}+", password)){
                                    StandardUser newUser = new StandardUser(1, username, password, firstName, lastName, Integer.parseInt(SSN), Integer.parseInt(phoneNumber));
                                    account.add(newUser);
                                }else {
                                    throw new Exception();
                                }
                            }else {
                                throw new Exception();
                            }
                        }else {
                            throw new Exception();
                        }
                    }else {
                        throw new Exception();
                    }
                }else {
                    throw new Exception();
                }
            }else {
                throw new Exception();
            }


            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("sampleLogin.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Wrong input");
            alert.setContentText("You have entered wrong input");
            alert.showAndWait();
        }

    }
}
