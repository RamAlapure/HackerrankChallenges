/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieinventory;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Ram
 */
public class MovieInventory extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label lblHeading = new Label("Movie Inventory");
        lblHeading.setFont(new Font("Arial", 20));
        
        TableView<Movie> table = new TableView<>();
        table.setItems(loadData()); 
        
        TableColumn<Movie, String> colTitle = new TableColumn("Title");
        colTitle.setMinWidth(300);
        colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        
        TableColumn<Movie, Integer> colYear = new TableColumn("Year"); 
        colYear.setMinWidth(100);
        colYear.setCellValueFactory(new PropertyValueFactory<>("Year"));
        
        TableColumn<Movie, Double> colPrice = new TableColumn("Price"); 
        colPrice.setMinWidth(100);
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        
        table.getColumns().addAll(colTitle, colYear, colPrice); 
        
        VBox paneMain = new VBox(); 
        paneMain.setSpacing(10);
        paneMain.setPadding(new Insets(10, 10, 10, 10));
        paneMain.getChildren().addAll(lblHeading, table);
        
        Scene scene = new Scene(paneMain); 
        primaryStage.setScene(scene);
        primaryStage.setTitle("Movie Inventory");
        primaryStage.show();
        }
        public ObservableList<Movie> loadData()
        {
        ObservableList<Movie> data =
        FXCollections.observableArrayList();
        data.add(new Movie("It's a Wonderful Life",
        1946, 14.95));
        data.add(new Movie("Young Frankenstein",
        1974, 16.95));
        data.add(new Movie("Star Wars Episode 4",
        1976, 17.95));
        data.add(new Movie("The Princess Bride",
        1987, 16.95));
        data.add(new Movie("Glory",
        1989, 14.95));
        data.add(new Movie("The Game",
        1997, 14.95));
        data.add(new Movie("Shakespeare in Love",
        1998, 19.95));
        data.add(new Movie("The Invention of Lying",
        2009, 18.95));
        data.add(new Movie("The King's Speech",
        2010, 19.95));
        return data; 
        }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
