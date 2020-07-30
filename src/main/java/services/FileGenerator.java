package services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import java.util.Scanner;


/**
 * Method for generating a specified number of files with a volume more or equal 1 GB.
 */
public class FileGenerator {

    private final static int MAX_INTEGER = 2147483647;
    private final static int NUMBERS_IN_FILE = 1073741824/10;
    private int howManyFiles = 20;
    private String fileName = "text";
    private File dir = new File("Demo");

    public int getHowManyFiles() {
        return howManyFiles;
    }

    public void setHowManyFiles(int howManyFiles) {
        this.howManyFiles = howManyFiles;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    // todo сначала логгирование, затем javadoc
    private void fileGeneratorRun() throws IOException {
        System.out.println("Welcome to the text file generator.");
        dir.mkdir();
        for (int i = 0; i < howManyFiles; i++) {
            File thisFile = createTheFile(fileName, i);
            OutputStream os = new FileOutputStream(thisFile);
            for (int j = 0; j <= NUMBERS_IN_FILE; j++) {
                fullTheFile(os);
            }
            os.close();
            System.out.println("Something written to file " + thisFile.getName() + ".");
        }
    }

    private void fullTheFile(OutputStream os) throws IOException {
        Random rand = new Random();
        String s = rand.nextInt(MAX_INTEGER) + ",";
        os.write(s.getBytes());
    }

    private File createTheFile(String fileName, int count) throws IOException {
        File theFile = new File(dir.toString() + "/" + fileName + count + ".txt");
        theFile.createNewFile();
        return theFile;
    }

    public File getDir() {
        return dir;
    }

    public void checkGeneratorRun() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter <y> to start the file generator.");
        String answer = in.nextLine();
        switch (answer) {
            case "y":
            case "у": {
                fileGeneratorRun();
                return;
            }
            default: {
                System.out.println("Generation will be skipped.");
            }
        }
    }
}

