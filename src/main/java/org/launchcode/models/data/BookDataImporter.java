package org.launchcode.models.data;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.launchcode.models.Book;

/**
 * Created by johnmilito on 4/24/17.
 */
//Borrowed from https://examples.javacodegeeks.com/core-java/apache/commons/csv-commons/writeread-csv-files-with-apache-commons-csv-example/
public class BookDataImporter {

    //CSV file header
    private static final String [] FILE_HEADER_MAPPING = {"EAN","Quantity","Price","created_date"};

    //Student attributes
    private static final String EAN = "EAN";
    private static final String QUANTITY = "Quantity";
    private static final String PRICE = "Price";
    private static final String CREATED_DATE = "created_date";

    private static String buyer_name = "Chegg";

    //String fileName = "book_data.csv";

    public static ArrayList<Book> importedBooks = new ArrayList<Book>();



    public static void readCsvFile(String fileName) {

        FileReader fileReader = null;

        CSVParser csvFileParser = null;

        //Create the CSVFormat object with the header mapping
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);

        try {

            //Create a new list of student to be filled by CSV file data
            List students = new ArrayList();

            //initialize FileReader object
            fileReader = new FileReader(fileName);

            //initialize CSVParser object
            csvFileParser = new CSVParser(fileReader, csvFileFormat);

            //Get a list of CSV file records
            List csvRecords = csvFileParser.getRecords();

            //Read the CSV file records starting from the second record to skip the header
            for (int i = 1; i < csvRecords.size(); i++) {
                CSVRecord record = (CSVRecord) csvRecords.get(i);
                //Create a new student object and fill his data
                Book abook = new Book(buyer_name, Long.parseLong(record.get(EAN)), Integer.parseInt(record.get(QUANTITY)), Double.parseDouble(record.get(PRICE)));
                importedBooks.add(abook);
            }

        }
        catch (Exception e) {
            System.out.println("Error in BookDataImporter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                csvFileParser.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader/csvFileParser !!!");
                e.printStackTrace();
            }
        }

    }

    public static ArrayList<Book> toList() {

        return importedBooks;
    }

    }