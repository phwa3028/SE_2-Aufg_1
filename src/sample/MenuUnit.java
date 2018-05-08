package sample;

import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class MenuUnit
{
    private final AnchorPane anchorPane;
    private final MenuBar menuBar;
    private final Menu menu;

    public MenuUnit(TelefonBook telefonBook){
        anchorPane = new AnchorPane();
        menuBar = new MenuBar();
        menu = new Menu("File");

        MenuItem book1 = new MenuItem("Book 1");
        MenuItem book2 = new MenuItem("Book 2");
        MenuItem merge = new MenuItem("Merge");

        book1.setOnAction(event -> {
            //System.out.println("Hey");
            StreamHandler.bookToRead = 0;
            telefonBook.LoadNewBook();
        });

        book2.setOnAction(event -> {
            //System.out.println("Ney");
            StreamHandler.bookToRead = 1;
            telefonBook.LoadNewBook();
        });

        merge.setOnAction(event -> {
            telefonBook.addOtherBook();
        });

        menu.getItems().addAll(book1, book2, merge);
        menuBar.getMenus().addAll(menu);
        anchorPane.getChildren().addAll(menuBar);
    }
    public Node getPane(){
        return anchorPane;
    }
}