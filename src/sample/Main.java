package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        BorderPane root = new BorderPane();
        TelefonBook telefonBook = new TelefonBook();

        EntryArea entryArea = new EntryArea(telefonBook.getTelefonEntries());
        SearchArea searchArea = new SearchArea(telefonBook.getTelefonEntries(), entryArea);
        DeleteArea deleteArea = new DeleteArea(telefonBook.getTelefonEntries(), entryArea, telefonBook);

        root.setTop(searchArea.getPane());
        root.setBottom(deleteArea.getPane());
        root.setCenter(entryArea.getAnchorPane());

        primaryStage.setTitle("Telefonbuch");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}