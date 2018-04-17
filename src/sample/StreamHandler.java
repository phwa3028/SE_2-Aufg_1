package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StreamHandler {

    private static String address = "ExportableTelefonBook";

    /**
     * Writes the Content of a Telefonbook into an external file.
     * @param telefonBook
     * @throws IOException
     */
    public static void write(TelefonBook telefonBook)throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(address));

        List<TelefonEntry> entries = telefonBook.getTelefonEntries();
        Iterator<TelefonEntry> telefonEntryIterator = entries.iterator();
        while(telefonEntryIterator.hasNext()){
            TelefonEntry entry = telefonEntryIterator.next();
            bufferedWriter.write(entry.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    /**
     * Creates a List of telefonnumbers from an external File
     * @return List of telefonnumbers
     */
    public  static List<TelefonEntry> read(){
        List<TelefonEntry> list = new ArrayList<>();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(address));
            boolean nextLine = true;
            while(nextLine){
                String s = bufferedReader.readLine();
                if(s != null) {
                    String[] properties = s.split(",");
                    list.add(new TelefonEntry(properties[0], properties[1], properties[2]));
                }else
                    return list;
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}