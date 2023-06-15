package Controller;

import java.io.IOException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ProfileController {
    @FXML
    ImageView imageView;

    @FXML
    StackPane stackPane;

    @FXML
    Button nextimage;

    @FXML
    TextField date;

    @FXML
    Label notvalidDate;

    @FXML
    RadioButton maleRadioButton, femaleRadioButton, otherRadioButton;

    @FXML
    private ChoiceBox<String> monthChoiceBox;

    @FXML
    private ChoiceBox<Integer> yearChoiceBox;

    

    @FXML
    private void handleDateValidation(ActionEvent event) {
        String input = date.getText();
        isValidDate(input);
    }

    public boolean isValidDate(String input) {
        if (!input.matches("\\d+")) {
            notvalidDate.setVisible(true);
        }

        int dateValue = Integer.parseInt(input);

        if (dateValue < 1 || dateValue > 31) {
            notvalidDate.setVisible(true); 
            return false;
        }

        notvalidDate.setVisible(false); 
        return true;
    }


    public void initialize() {
   

        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
    
        monthChoiceBox.getItems().addAll(months);

    
        int currentYear = LocalDate.now().getYear();
        for (int i = currentYear - 50; i <= currentYear; i++) {
            yearChoiceBox.getItems().add(i);
        }
    }

   @FXML
    private void handleMaleRadioButton(ActionEvent event) {
        boolean selected = maleRadioButton.isSelected();
        femaleRadioButton.setDisable(selected);
        otherRadioButton.setDisable(selected);
    }

    @FXML
    private void handleFemaleRadioButton(ActionEvent event) {
        boolean selected = femaleRadioButton.isSelected();
        maleRadioButton.setDisable(selected);
        otherRadioButton.setDisable(selected);
    }

    @FXML
    private void handleOtherRadioButton(ActionEvent event) {
        boolean selected = otherRadioButton.isSelected();
        maleRadioButton.setDisable(selected);
        femaleRadioButton.setDisable(selected);
    }



    //STACK PANE CONTROL
    private int currentPictureIndex = 0;

    private final Image[] pictures = { 
        new Image("Images/avatar1.png"),
        new Image("Images/avatar2.png"),
        new Image("Images/avatar3.png"),
        new Image("Images/avatar4.png")
    };

    @FXML
    private void nextimage(ActionEvent event) {

        if (currentPictureIndex >= 0 && currentPictureIndex < pictures.length) {
            ImageView previousImageView = (ImageView) stackPane.getChildren().get(currentPictureIndex);
            previousImageView.setVisible(false);
        }
        currentPictureIndex = (currentPictureIndex + 3) % pictures.length;
    
        ImageView nextImageView = (ImageView) stackPane.getChildren().get(currentPictureIndex);
        nextImageView.setVisible(true);
    }
    
    public void gotoHome(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Home.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void gotoAbout(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/About.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void gotoShop(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ShopProducts.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void gotoCart(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Cart1of2.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void gotoLogin(ActionEvent event) throws IOException {
        Alert confirmation = new Alert(AlertType.CONFIRMATION);
        confirmation.setTitle("Sign Out");
        confirmation.setHeaderText(null);
        confirmation.setContentText("Are you sure you want to sign out?");
        confirmation.showAndWait();

        if (confirmation.getResult() == ButtonType.OK) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Signin.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
