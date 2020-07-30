package client;

import services.FileGenerator;
import services.SearchService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Application {


    public static void main(String[] args) throws IOException, SQLException {

        //fileGeneration
        FileGenerator fg = new FileGenerator();
        fg.checkGeneratorRun();

        //searchService + dBsaving
        SearchService ss = new SearchService();
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter an Integer number to search in files.");
        int number = Integer.parseInt(in.nextLine());
        ss.findNumber(number, fg.getDir());
    }
}



