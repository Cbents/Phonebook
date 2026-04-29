import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Phonebook {

    ArrayList<ContactCard> phonebook = new ArrayList<>();

    public void readFromFile(){
        try (Scanner reader = new Scanner(new File("contacts.txt"))){
            while (reader.hasNextLine()){
                String next = reader.nextLine();
                try {
                    addContact(next.split(": ")[0],next.split(": ")[1]);
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
        try (FileWriter writer = new FileWriter("contacts.txt")){
            for (Contact s : list) {
                addToFile += s + "\n";
            }
            writer.write(addToFile);
            System.out.println("Saved to file");
        }

        catch (IOException e){
            System.out.println("An error occurred while writing" + " to the file: " + e.getMessage());
        }
    }


    public void findContact(String search){
        int length = search.length();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getName().substring(0,length).equals(search))
                System.out.println(list.get(i).toString());
            else if (list.get(i).getNumber().substring(0,length).equals(search))
                System.out.println(list.get(i).toString());
        }
    }

    public void deleteContact(String delete){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getName().equals(delete) || list.get(i).getNumber().equals(delete)) {
                System.out.print("Deleted " + list.get(i).toString() + " from contacts.");
                list.remove(i);
            }
            else System.out.print("Contact not found.");
        }
    }
}


