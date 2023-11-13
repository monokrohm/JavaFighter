import java.io.PrintWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class is used to operate file input and output
 * 
 * @author Raymond Fung
 * @version ver 1.0.0
 */
public class FileIO {
    private String filename;

    /**
     * Default constructor which creates the object of the class FileIO.
     */
    public FileIO() {
        filename = "";
    }

    /**
     * Non-Default constructor which creates the object of the class FileIO.
     *
     * @param filename Accepts String value of the name for input and output files
     */
    public FileIO(String filename) {
        this.filename = filename;
    }

    /**
     * Accessor method to get the current name to be used for the file
     *
     * @return The name of the file as a string
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Used to read files
     *
     * @return Concatenated contents as a string
     */
    public String readFile() {
        String data = "";
        try {
            if (filename.trim().length() > 0) {
                FileReader reader = new FileReader(filename);
                Scanner readFile = new Scanner(reader);
                while (readFile.hasNextLine()) {
                    data += readFile.nextLine() + "\n";
                }
                reader.close();
            } else {
                System.out.println("Invalid Filename or File Does Not Exist!");
            }
        } catch (IOException e) {
            System.out.println("Invalid Filename or File Does Not Exist!!");
        } catch (Exception e) {
            System.out.println("Invalid Filename or File Does Not Exist!!!");
        }

        return data;
    }

    /**
     * Mutator method to set the name to be used for the file
     *
     * @param filename String of the name to be used
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Used to write files
     *
     * @param data String of content to be written
     */
    public void writeFile(String data) {
        try {
            if (filename.trim().length() > 0) {
                PrintWriter write = new PrintWriter(filename);
                write.println(data);
                write.close();
            } else {
                System.out.println("Invalid Filename or File Does Not Exist");
            }
        } catch (IOException e) {
            System.out.println("Error Writing to File...");
        } catch (Exception e) {
            System.out.println("Error Writing to File...");
        }
    }
}