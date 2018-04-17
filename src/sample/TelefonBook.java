package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TelefonBook {

    private ObservableList<TelefonEntry> telefonEntries;

    public TelefonBook(){
        telefonEntries = FXCollections.observableArrayList();
        telefonEntries.addAll(StreamHandler.read());
    }

    public ObservableList<TelefonEntry> getTelefonEntries() {
        return telefonEntries;
    }

    /**
     * Adds a given Entry to the Telefonbook
     * @param lastName
     * @param firstName
     * @param number
     */
    public void addNumber(String lastName, String firstName, String number){
        telefonEntries.addAll(new TelefonEntry(lastName, firstName, number));
    }

    /**
     * Removes a given Entry from the Telefonbook
     * @param telefonEntry
     */
    public void delNumber(TelefonEntry telefonEntry){
        telefonEntries.remove(telefonEntry);
    }

}