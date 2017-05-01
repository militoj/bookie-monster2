package org.launchcode.models;

import org.launchcode.models.data.BookDataWriter;
import org.launchcode.models.data.BookDataImporter;
import org.launchcode.models.data.Scraper;
import org.launchcode.models.data.apiRequester;



import java.lang.reflect.Array;
import java.util.ArrayList;



/**
 * Created by johnmilito on 4/30/17.
 */
public class Runner {


    public static void main(String[]args){
        BookDataImporter.readCsvFile("/Users/johnmilito/git/bookies-revenge/src/main/resources/book_data.csv");
        Scraper.main();

        ArrayList<Book> testList = BookDataImporter.toList();

        ArrayList<Book> firstList = BookDataImporter.toList();
        ArrayList<Book> secondList = Scraper.toList();

        firstList.addAll(secondList);


        BookDataWriter.writeCsvFile("/Users/johnmilito/git/bookies-revenge/src/main/resources/BookFileNew.csv", firstList);

        apiRequester.urlMaker(testList);


    }
}
