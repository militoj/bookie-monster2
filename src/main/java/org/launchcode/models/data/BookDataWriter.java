package org.launchcode.models.data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.launchcode.models.Book;

/**
 * Created by johnmilito on 4/24/17.
 */
//Borrowed from https://examples.javacodegeeks.com/core-java/apache/commons/csv-commons/writeread-csv-files-with-apache-commons-csv-example/
public class BookDataWriter {






        //Delimiter used in CSV file
        private static final String NEW_LINE_SEPARATOR = "\n";

        //CSV file header
        private static final Object [] FILE_HEADER = {"id","quantity","isbn","price","amazon price"};

        public static void writeCsvFile(String fileName) {


            //Create a new list of student objects
            List <Book> booksToWrite = BookDataImporter.importedBooks;


            FileWriter fileWriter = null;

            CSVPrinter csvFilePrinter = null;

            //Create the CSVFormat object with "\n" as a record delimiter
            CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

            try {

                //initialize FileWriter object
                fileWriter = new FileWriter(fileName);

                //initialize CSVPrinter object
                csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

                //Create CSV file header
                csvFilePrinter.printRecord(FILE_HEADER);

                //Write a new student object list to the CSV file
                for (Book book : booksToWrite) {
                    List bookDataRecord = new ArrayList();
                    bookDataRecord.add(book.getBuyer_name());
                    bookDataRecord.add(String.valueOf(book.getQuantity()));
                    bookDataRecord.add(String.valueOf(book.getISBN()));
                    bookDataRecord.add(String.valueOf(book.getPrice()));
                    bookDataRecord.add(String.valueOf(book.getAmazon_price()));
                    csvFilePrinter.printRecord(bookDataRecord);
                }

                System.out.println("CSV file was created successfully !!!");

            } catch (Exception e) {
                System.out.println("Error in CsvFileWriter !!!");
                e.printStackTrace();
            } finally {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                    csvFilePrinter.close();
                } catch (IOException e) {
                    System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
                    e.printStackTrace();
                }
            }
        }

}
