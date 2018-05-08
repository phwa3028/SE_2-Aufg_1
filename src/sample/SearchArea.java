package sample;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchArea {
    private final AnchorPane pane = new AnchorPane();
    private final Button button = new Button("Search");
    private final TextField textField = new TextField();
    private final MenuUnit menuUnit;

    public SearchArea(ObservableList<TelefonEntry> telefonEntries, EntryArea entryArea, TelefonBook telefonBook){
        menuUnit = new MenuUnit(telefonBook);
        AnchorPane.setTopAnchor(menuUnit.getPane(), 0.0);

        AnchorPane.setLeftAnchor(textField, 10.0);
        AnchorPane.setTopAnchor(textField, 30.0);
        AnchorPane.setBottomAnchor(textField, 10.0);
        AnchorPane.setRightAnchor(textField, 90.0);

        AnchorPane.setRightAnchor(button, 10.0);
        AnchorPane.setTopAnchor(button, 10.0);
        AnchorPane.setBottomAnchor(button, 10.0);

        button.onMouseClickedProperty().setValue(event -> {
            entryArea.clear();
            String toSearch = textField.getText();
            String[] properties = toSearch.split(" ");
            Iterator<TelefonEntry> telefonEntryIterator = telefonEntries.iterator();
            List<TelefonEntry> selection = new ArrayList<>();
            while(telefonEntryIterator.hasNext()) {
                TelefonEntry entry = telefonEntryIterator.next();
                for (int i = 0; i < properties.length; i++) {
                    if (entry.getFirstName().equals(properties[i]) || entry.getLastName().equals(properties[i])
                            || entry.getNumber().equals(properties[i])) {
                        selection.add(entry);
                    }
                }
                entryArea.selectItems(selection);
            }
        });

        pane.getChildren().addAll(textField, button, menuUnit.getPane());
    }
    public Node getPane(){
        return pane;
    }
}