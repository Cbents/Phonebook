import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Phonebook {
    //hello?


    public void readFromFile(){
        try (Scanner reader = new Scanner(new File("contacts.txt"))){
            while (reader.hasNextLine()){
                String next = reader.nextLine();
                try {
                    addContact(next);
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.print("Not a valid contact.");
                }

            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public void saveToFile(){
        String addToFile = "";
        try (FileWriter writer = new FileWriter("contacts.txt")){\
            for (String s : list.toString) {
                addToFile += s + "\n";
            }
            writer.write(addToFile);
            System.out.println("Saved to file");
        }

        catch (IOException e){
            System.out.println("An error occurred while writing" + " to the file: " + e.getMessage());
        }
    }


    public String findContact(String search){
        int length = search.length();
        for (int i = 0; i < list.length; i++){
            if (list[i].getName().substring(0,length).equals(search))
                System.out.print(list[i]);
            else if (list[i].getNumber().substring(0,length).equals(search))
                System.out.print(list[i]);
        }
    }
}


