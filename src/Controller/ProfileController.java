package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ProfileController {
    @FXML
    ImageView imageView;

    @FXML
    StackPane stackPane;

    @FXML
    Label usernameLabel, nameLabel, emailLabel, numberLabel;

    @FXML
    Button save, edit;

    @FXML
    Button nextimage;

    @FXML
    TextField usernameTF, nameTF, emailTF, numberTF;

    @FXML
    RadioButton maleRadioButton, femaleRadioButton, otherRadioButton;

    @FXML
    Label radioValidationLabel, dateValidationLabel; 

    @FXML
    private ComboBox<String> monthComboBox;

    @FXML
    private ComboBox<Integer> dayComboBox;

    @FXML
    private ComboBox<Integer> yearComboBox;

    BlogController blogController = null;

    private UserRepository userRepository;

    public void initialize() {

        userRepository = UserRepository.getInstance();
        ArrayList<User> userList = userRepository.getUserList();

        if (!userList.isEmpty()) {
            User user = userList.get(0); 
            updateLabels(user);
        }

        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        monthComboBox.getItems().addAll(months);

        int currentYear = LocalDate.now().getYear();
        for (int i = currentYear - 50; i <= currentYear; i++) {
            yearComboBox.getItems().add(i);
        }

        int daysInMonth = LocalDate.now().lengthOfMonth();
        for (int i = 1; i <= daysInMonth; i++) {
            dayComboBox.getItems().add(i);
        }
    }

    private void updateLabels(User user) {
        usernameLabel.setText(user.getUsername());
        emailLabel.setText(user.getEmail());
        numberLabel.setText(user.getNumber());
        nameLabel.setText(user.getName());
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

    private boolean isSaved = false;

    @FXML
    private void handleEditButton(ActionEvent event) {
        if (isSaved) {
            // Enable the buttons and fields
            nextimage.setDisable(false);
            maleRadioButton.setDisable(false);
            femaleRadioButton.setDisable(false);
            otherRadioButton.setDisable(false);
            monthComboBox.setDisable(false);
            dayComboBox.setDisable(false);
            yearComboBox.setDisable(false);
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Save Required");
            alert.setContentText("Please save your changes before editing.");
            alert.showAndWait();
        }
    }


    @FXML
    private void handleSaveButton(ActionEvent event) {
        
        boolean isValid = true;

        boolean isRadioButtonSelected = maleRadioButton.isSelected()
                || femaleRadioButton.isSelected()
                || otherRadioButton.isSelected();
        if (!isRadioButtonSelected) {
            isValid = false;
            radioValidationLabel.setText("Please select one.");
        } else {
            radioValidationLabel.setText("");
        }

        boolean isMonthSelected = monthComboBox.getSelectionModel().getSelectedItem() != null;
        boolean isDaySelected = dayComboBox.getSelectionModel().getSelectedItem() != null;
        boolean isYearSelected = yearComboBox.getSelectionModel().getSelectedItem() != null;
        if (!isMonthSelected || !isDaySelected || !isYearSelected) {
            isValid = false;
            dateValidationLabel.setText("Please select date of birth.");
        } else {
            dateValidationLabel.setText("");
        }

        if (isValid) {

            nextimage.setDisable(true);
            maleRadioButton.setDisable(true);
            femaleRadioButton.setDisable(true);
            otherRadioButton.setDisable(true);
            monthComboBox.setDisable(true);
            dayComboBox.setDisable(true);
            yearComboBox.setDisable(true);

            isSaved = true;
        }
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

         FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void gotoAbout(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/About.fxml"));
        Parent root = loader.load();

         FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void gotoShop(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to proceed? There is no going back!");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ShopProducts.fxml"));
        Parent root = loader.load();

         FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        }
    }

    @FXML
    public void gotoBlog(ActionEvent event) throws IOException {
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Webview.fxml"));
          Parent root = loader.load();
          blogController = loader.getController();

           FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

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

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void setProfileData(ArrayList<String> profileData) {
    if (profileData.size() >= 4) {
        String username = profileData.get(0);
        String name = profileData.get(1);
        String email = profileData.get(2);
        String number = profileData.get(3);

        usernameLabel.setText(username);
        nameLabel.setText(name);
        emailLabel.setText(email);
        numberLabel.setText(number);
    }
}


}
