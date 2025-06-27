import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class NotesManager {
    private static final String fileName = "notes.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;

        while (true) {
            System.out.println("\n---------------------NOTES MANAGER---------------------");
            System.out.println("1.Add Notes");
            System.out.println("2.View Notes");
            System.out.println("3.Exit");
            System.out.println("Enter any number 1 , 2 and 3 :");
            try {
                option = Integer.parseInt(sc.nextLine());

                switch (option) {
                    case 1:
                        addNote(sc);
                        break;
                    case 2:
                        viewNote();
                        break;
                    case 3:
                        System.out.println("Exiting from Notes..");
                        sc.close();
                        return;
                    default:
                        System.out.println("please choose from 1 , 2 and 3...");
                }
            } catch (Exception e) {
                System.out.println("please enter a valid number.." + e.getMessage());
            }
        }
    }

    public static void addNote(Scanner sc) {
        System.out.println("Enter your note");
        String note = sc.nextLine();
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write(note + System.lineSeparator());
            System.out.println("Your note saved successfully..");
        } catch (Exception e) {
            System.out.println("Found some problem while writting to file" + e.getMessage());
        }
    }

    public static void viewNote() {
        File f = new File(fileName);
        if (!f.exists()) {
            System.out.println("No notes found.");
            return;
        }
        System.out.println("\n*****************YOUR NOTES*****************");
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int count = 1;
            while ((line = br.readLine()) != null) {
                System.out.println(count++ + "." + line);
            }
        } catch (Exception e) {
            System.out.println("Found some problem while reading from file. " + e.getMessage());
        }
    }

}
