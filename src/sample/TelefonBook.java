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

    public void LoadNewBook(){
        telefonEntries.clear();
        telefonEntries.addAll(StreamHandler.read());
    }
    public void addOtherBook(){
        if(StreamHandler.bookToRead == 0){
            StreamHandler.bookToRead = 1;
            telefonEntries.addAll(StreamHandler.read());
            StreamHandler.bookToRead = 0;
        }
        if(StreamHandler.bookToRead == 1){
            StreamHandler.bookToRead = 0;
            telefonEntries.addAll(StreamHandler.read());
            StreamHandler.bookToRead = 1;
        }
    }

}