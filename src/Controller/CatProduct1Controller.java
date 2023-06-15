package Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class CatProduct1Controller{
    
    @FXML
    Button CatCategory;

    @FXML
    ImageView imageView;

    @FXML
    Button nextimage, pawgntbtn, lowestpricebtn, closeButton;

    @FXML
    Label namec1, namec11, namec111, pricec1;

    @FXML
    private StackPane stackPane;


    //STACK PANE CONTROL
    private int currentPictureIndex = 0;

    private final Image[] pictures = { 
        new Image("Images/C1. PRODUCT.png"),
        new Image("Images/C1.2 PRODUCT.png"),
        new Image("Images/C1.3 PRODUCT.png")
    };

    @FXML
    private void handleNextButtonClick(ActionEvent event) {

        if (currentPictureIndex >= 0 && currentPictureIndex < pictures.length) {
            ImageView previousImageView = (ImageView) stackPane.getChildren().get(currentPictureIndex);
            previousImageView.setVisible(false);
        }
        currentPictureIndex = (currentPictureIndex + 2) % pictures.length;
    
        ImageView nextImageView = (ImageView) stackPane.getChildren().get(currentPictureIndex);
        nextImageView.setVisible(true);
    }

    //ALERT MESSAGE LOWEST PRICE & PAW GUARANTEE
    @FXML
    private void handlePawgntButtonClick(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Paw Guarantee");
        alert.setHeaderText(null);
        alert.setContentText("With the Paw Guarantee, we are dedicated to enhancing your shopping experience and prioritizing your pet's well-being!");
        alert.showAndWait();
    }

    @FXML
    private void handleLowestPriceButtonClick(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Lowest Price Guaranteed");
        alert.setHeaderText(null);
        alert.setContentText("At Paw, we understand that providing the best products for your beloved pets shouldn't break the bank!");
        alert.showAndWait();
    
    }
    @FXML
     private void closeScene(ActionEvent event) {
        Button closeButton = (Button) event.getSource();
        Stage currentStage = (Stage) closeButton.getScene().getWindow();
        currentStage.close();
    }

}
