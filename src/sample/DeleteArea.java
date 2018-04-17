package sample;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DeleteArea {
    private final AnchorPane pane = new AnchorPane();
    private final Button delButton = new Button("Delete");
    private final Button addButton = new Button("Add");
    private final Button safeButton = new Button("Safe");

    public DeleteArea(ObservableList<TelefonEntry> telefonEntries, EntryArea entryArea, TelefonBook telefonBook){
        AnchorPane.setBottomAnchor(delButton, 10.0);
        AnchorPane.setRightAnchor(delButton, 10.0);

        AnchorPane.setBottomAnchor(addButton, 10.0);
        AnchorPane.setLeftAnchor(addButton, 10.0);

        AnchorPane.setBottomAnchor(safeButton, 10.0);
        AnchorPane.setLeftAnchor(safeButton, 50.0);

        pane.getChildren().addAll(delButton, addButton, safeButton);

        delButton.onMouseClickedProperty().setValue(event -> {
            telefonEntries.remove(entryArea.getSelectedEntries());
        });

        addButton.onMouseClickedProperty().setValue(event -> {
            telefonEntries.addAll(new TelefonEntry("...", "...", "..."));
        });

        safeButton.onMouseClickedProperty().setValue(event -> {
            try {
                System.out.println("Hey");
                StreamHandler.write(telefonBook);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    public Node getPane() {
        return pane;
    }
}