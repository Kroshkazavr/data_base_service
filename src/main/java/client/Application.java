package client;

import dataBase.dBDAO;
import entity.Result;
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

        //searchService
        SearchService ss = new SearchService();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите Integer число для поиска.");
        int number = Integer.parseInt(in.nextLine());
        Result result = ss.findNumber(number, fg.getDir());
        System.out.println(result);

        //DB
        dBDAO dao = new dBDAO();
        dao.saveResult(result, number);
    }
}



