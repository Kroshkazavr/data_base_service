package fileGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import java.util.Scanner;

//todo для логгера

public class FileGenerator {

    private final static int MAX_INTEGER = 2147483647;
    private final static int CIRCLE_COUNT = 10000;//1073741824/10; //todo гиг поделить на размер инт в байт
    private int howManyFiles = 20;
    private String fileName = "text";
    private File dir = new File("Demo");

    public static int getMaxInteger() {
        return MAX_INTEGER;
    }

    public static int getCircleCount() {
        return CIRCLE_COUNT;
    }

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

    private void fileGeneratorRun() throws IOException {
        System.out.println("Добро пожаловать в генератор текстовых файлов.");
        dir.mkdir();
        for (int i = 0; i < howManyFiles; i++) {
            File thisFile = createTheFile(fileName, i);
            OutputStream os = new FileOutputStream(thisFile);
            for (int j = 0; j <= CIRCLE_COUNT; j++) {
                fullTheFile(os);
            }
            os.close();
            System.out.println("Записали кое-что в файл " + thisFile.getName() + ".");
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

    public boolean checkGeneratorRun() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите <y> для запуска генератора файлов.");
        String answer = in.nextLine();
        switch (answer) {
            case "y":
            case "у": {
                fileGeneratorRun();
                return true;
            }
            default: {
                System.out.println("Генерация выполнена не будет.");
                return false;
            }
        }
    }
}

