package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import Model.CatProduct1;
import Model.CatProduct2;
import Model.CatProduct3;
import Model.DogProduct1;
import Model.DogProduct2;
import Model.DogProduct3;
import Model.SmallPetProduct1;
import Model.SmallPetProduct2;
import Model.SmallPetProduct3;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import javafx.fxml.Initializable;


import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;



public class ShopController implements Initializable{
    
    @FXML
    Button homebutton, aboutbutton, shopbutton, blogsbutton, profilebtn, signoutbtn,
    addcartbtn1, addcartbtn2, addcartbtn3, addcartbtn4, addcartbtn5, addcartbtn6, addcartbtn7, addcartbtn8, addcartbtn9;

    @FXML
    Button dogcategory, catcategory, smallpetcategory, dogprod1, dogprod2, dogprod3, catprod1, catprod2, catprod3, smallpetprod1, smallpetprod2, smallpetprod3;

//-------------------------

    @FXML
    ImageView imageView;

    @FXML
    private StackPane stackPane;

    Parent root;

    FXMLLoader loader;

    @FXML
    Label namec1, namec2, namec3, pricec1, pricec2, pricec3,
    named1, named2, named3, priced1, priced2, priced3,
    names1, names2, names3, prices1, prices2, prices3;

    @FXML
    Cart1of2Controller checkoutController = null;

    static CatProduct1 c1 = new CatProduct1();
  
    static CatProduct2 c2 = new CatProduct2();
    
    static CatProduct3 c3 = new CatProduct3();
  
    static DogProduct1 d1 = new DogProduct1();
  
    static DogProduct2 d2 = new DogProduct2();
   
    static DogProduct3 d3 = new DogProduct3();
    
    static SmallPetProduct1 s1 = new SmallPetProduct1();
    
    static SmallPetProduct2 s2 = new SmallPetProduct2();
   
    static SmallPetProduct3 s3 = new SmallPetProduct3();
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {

          c1.setProductName("Whiskas Junior Ocean Fish");
          namec1.setText(c1.getProductName());
  
          c1.setProductPrice(349);
          pricec1.setText(Double.toString(c1.getProductPrice()));


          c2.setProductName("SmartHeart Adult Chicken");
          namec2.setText(c2.getProductName());
        
          c2.setProductPrice(299);
          pricec2.setText(Double.toString(c2.getProductPrice()));


          c3.setProductName("Ciao Jelly Tuna with Cuttle");
          namec3.setText(c3.getProductName());
         
          c3.setProductPrice(100);
          pricec3.setText(Double.toString(c3.getProductPrice()));

          d1.setProductName("Pedigree Grilled Steak");
          named1.setText(d1.getProductName());
         
          d1.setProductPrice(1518);
          priced1.setText(Double.toString(d1.getProductPrice()));


          d2.setProductName("Bil-Jac Picky No More");
          named2.setText(d2.getProductName());
         
          d2.setProductPrice(1200);
          priced2.setText(Double.toString(d2.getProductPrice()));


          d3.setProductName("CESAR Simply Crafted ");
          named3.setText(d3.getProductName());
          
          d3.setProductPrice(437);
          priced3.setText(Double.toString(d3.getProductPrice()));          


          s1.setProductName("HOPERAN Wooden Hamster");
          names1.setText(s1.getProductName());
          
          s1.setProductPrice(13859);
          prices1.setText(Double.toString(s1.getProductPrice()));


          s2.setProductName("Vitakraft Small Animal");
          names2.setText(s2.getProductName());
          
          s2.setProductPrice(1374.0);
          prices2.setText(Double.toString(s2.getProductPrice()));


          s3.setProductName("Freshwater Aquarium Test");
          names3.setText(s3.getProductName());
         
          s3.setProductPrice(1294.0);
          prices3.setText(Double.toString(s3.getProductPrice()));


        try {
            loader = new FXMLLoader(getClass().getResource("/view/Cart1of2.fxml"));
            root = loader.load();
        } catch (Exception e) {
            // TODO: handle exception
        }

        // Clears all items in Checkout.fxml
        checkoutController = loader.getController();
        checkoutController.myvbox.getChildren().removeAll(checkoutController.myvbox.getChildren());

    
    }

    public void buy(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Add to Cart");
        alert.setHeaderText(null);
        alert.setContentText("Item successfully added to cart, thank you!");
        alert.showAndWait();

        Button sourceButton = (Button) event.getSource();

        // If addtocart button is pressed, set product status to true
        if (sourceButton.equals(addcartbtn1)) {
            c1.setProductStatus(true);
            ShopController.c1.setProductQuantity(1);
            checkoutController.addItem(checkoutController.pane1);
        }

       else if (sourceButton == addcartbtn2) {
            c2.setProductStatus(true);
            ShopController.c2.setProductQuantity(1);
            checkoutController.addItem(checkoutController.pane2);
        }

        else if (sourceButton == addcartbtn3) {
            c3.setProductStatus(true);
            ShopController.c3.setProductQuantity(1);
            checkoutController.addItem(checkoutController.pane3);
        }

        else if (sourceButton == addcartbtn4) {
            d1.setProductStatus(true);
            ShopController.d1.setProductQuantity(1);
            checkoutController.addItem(checkoutController.pane4);
        }

        else if (sourceButton == addcartbtn5) {
            d2.setProductStatus(true);
            ShopController.d2.setProductQuantity(1);
            checkoutController.addItem(checkoutController.pane5);
        }

        else if (sourceButton == addcartbtn6) {
            d3.setProductStatus(true);
            ShopController.d3.setProductQuantity(1);
            checkoutController.addItem(checkoutController.pane6);
        }

        else if (sourceButton == addcartbtn7) {
            s1.setProductStatus(true);
            ShopController.s1.setProductQuantity(1);
            checkoutController.addItem(checkoutController.pane7);
        }

        else if (sourceButton == addcartbtn8) {
            s2.setProductStatus(true);
            ShopController.s2.setProductQuantity(1);
            checkoutController.addItem(checkoutController.pane8);
        }

        else if (sourceButton == addcartbtn9) {
            s3.setProductStatus(true);
            ShopController.s3.setProductQuantity(1);
            checkoutController.addItem(checkoutController.pane9);
        }  
    }

//-------------------------
    //GO TO CATEGORIES CONTROL

    @FXML
    public void gotoDogCategory(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/ShopDog.fxml")); 
        Stage newStage = new Stage();
        
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }
    

    @FXML
    public void gotoCatCategory(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/ShopCat.fxml")); 
        Stage newStage = new Stage();
        
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    public void gotoSmallPetCategory(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/ShopSmallPet.fxml")); 
        Stage newStage = new Stage();
        
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }

    //GO TO PRODUCTS CONTROL

    @FXML
    public void gotoDogProd1(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/DogProduct1.fxml")); 
        Stage newStage = new Stage();
        
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();

    }

    @FXML
    public void gotoDogProd2(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/DogProduct2.fxml")); 
        Stage newStage = new Stage();
        
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    
    }

    @FXML
    public void gotoDogProd3(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/DogProduct3.fxml")); 
        Stage newStage = new Stage();
        
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    
    }

    @FXML
    public void gotoCatProd1(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/CatProduct1.fxml")); 
        Stage newStage = new Stage();
        
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();

    }

    @FXML
    public void gotoCatProd2(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/CatProduct2.fxml")); 
        Stage newStage = new Stage();
        
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();

    }

    @FXML
    public void gotoCatProd3(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/CatProduct3.fxml")); 
        Stage newStage = new Stage();
        
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();

    }

    @FXML
    public void gotoSmallPetProd1(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/SmallProduct1.fxml")); 
        Stage newStage = new Stage();
        
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();

    }

    @FXML
    public void gotoSmallPetProd2(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/SmallProduct2.fxml")); 
        Stage newStage = new Stage();
        
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();

    }

     @FXML
    public void gotoSmallPetProd3(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/SmallProduct3.fxml")); 
        Stage newStage = new Stage();
        
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    
    }
   
    @FXML
    public void gotoCart(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to go to Cart? There is no going back!");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            
            checkoutController.getInitialAmount();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
