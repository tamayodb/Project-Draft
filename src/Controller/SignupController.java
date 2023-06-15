package Controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignupController {

    @FXML
    private TextField usernameTF, numberTF, emailTF;

    @FXML
    private PasswordField passwordPF;

    @FXML
    private Button signupBT;

    @FXML
    private Label mywarninglabel1, mywarninglabel2, mywarninglabel3, mywarninglabel4;

    @FXML
    private SigninController signinController = null;

    public void signup(ActionEvent event) throws IOException {
        String username = usernameTF.getText();
        String number = numberTF.getText();
        String email = emailTF.getText();
        String password = passwordPF.getText();

        boolean validationsPassed = true;

        if (!isValidUsername(username)) {
            mywarninglabel1.setText("Username should contain both letters and numbers.");
            mywarninglabel1.setVisible(true);
            validationsPassed = false;
        } else {
            mywarninglabel1.setVisible(false);
        }
        
        if (!isValidNumber(number)) {
            mywarninglabel2.setText("Number should contain exactly 11 digits.");
            mywarninglabel2.setVisible(true);
            validationsPassed = false;
        } else {
            mywarninglabel2.setVisible(false);
        }
        
        if (!isValidEmail(email)) {
            mywarninglabel3.setText("Email should end with '@gmail.com'.");
            mywarninglabel3.setVisible(true);
            validationsPassed = false;
        } else {
            mywarninglabel3.setVisible(false);
        }
        
        if (!isValidPassword(password)) {
            mywarninglabel4.setText("Password should contain one number and special character.");
            mywarninglabel4.setVisible(true);
            validationsPassed = false;
        } else {
            mywarninglabel4.setVisible(false);
        }

        if (validationsPassed) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Signin.fxml"));
            Parent root = loader.load();
            signinController = loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    private boolean isValidUsername(String username) {
        Pattern pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d).+$");
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    private boolean isValidNumber(String number) {
        return number.matches("^\\d{11}$");
    }

    private boolean isValidEmail(String email) {
        return email.endsWith("@gmail.com");
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*\\d)(?=.*[^a-zA-Z\\d\\s]).+$");
    }
}
