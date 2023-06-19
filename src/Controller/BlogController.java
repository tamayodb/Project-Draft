package Controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BlogController implements Initializable{

	@FXML
	private WebView webView;
	@FXML
	private TextField textField;
	
	private WebEngine engine;
	private WebHistory history;
	private String homePage;
	private double webZoom;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		engine = webView.getEngine();
		homePage = "christianjoshuaalberto2.wordpress.com/2023/06/15/exploring-the-world-of-pets-fun-facts-health-tips-and-must-have-dog-products/";
		//textField.setText(homePage);
		//webZoom = 1;
		loadPage();
	}
	
	public void loadPage() {
		
		//engine.load("http://www.google.com");
		engine.load("http://"+homePage);
	}

    @FXML
    public void gotoAbout(ActionEvent event) throws IOException {
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/About.fxml"));
            Parent root = loader.load();

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
    @FXML
    public void gotoShop(ActionEvent event) throws IOException {
        Alert confirmation = new Alert(AlertType.CONFIRMATION);
        confirmation.setTitle("Confirmation");
        confirmation.setHeaderText(null);
        confirmation.setContentText("Are you sure you want to proceed? There is no going back!");
        confirmation.showAndWait();

        if (confirmation.getResult() == ButtonType.OK) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ShopProducts.fxml"));
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
    public void gotoHome(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Home.fxml"));
        Parent root = loader.load();

         FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void gotoProfile(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Profile.fxml"));
        Parent root = loader.load();

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
    
	
	/*public void refreshPage() {
		
		engine.reload();
	}
	
	public void zoomIn() {
		
		webZoom+=0.25;
		webView.setZoom(webZoom);
	}
	
	public void zoomOut() {
		
		webZoom-=0.25;
		webView.setZoom(webZoom);
	}
	
	public void displayHistory() {
		
		history = engine.getHistory();
		ObservableList<WebHistory.Entry> entries = history.getEntries();
		
		for(WebHistory.Entry entry : entries) {
			
			//System.out.println(entry);
			System.out.println(entry.getUrl()+" "+entry.getLastVisitedDate());
		}
	}
	
	public void back() {
		
		history = engine.getHistory();
		ObservableList<WebHistory.Entry> entries = history.getEntries();
		history.go(-1);
		
		textField.setText(entries.get(history.getCurrentIndex()).getUrl());
	}
	
	public void forward() {
		
		history = engine.getHistory();
		ObservableList<WebHistory.Entry> entries = history.getEntries();
		history.go(1);
		
		textField.setText(entries.get(history.getCurrentIndex()).getUrl());
	}
	
	public void executeJS() {
		
		engine.executeScript("window.location = \"https://www.youtube.com\";");
	}*/

}