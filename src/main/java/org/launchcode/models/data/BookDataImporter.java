package org.launchcode.models.data;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.launchcode.models.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by LaunchCode
 */
public class BookDataImporter {

    private static final String DATA_FILE = "book_data.csv";
    private static boolean isDataLoaded = false;

    static ArrayList<Book> importedBooks = new ArrayList<Book>();


    /**
     * Read in data from a CSV file and store it in a list
     */
    static void loadData() {

        // Only load data once
        if (isDataLoaded) {
            return;
        }

        try {

            // Open the CSV file and set up pull out column header info and records
            Resource resource = new ClassPathResource(DATA_FILE);
            InputStream is = resource.getInputStream();
            Reader reader = new InputStreamReader(is);
            CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            List<CSVRecord> records = parser.getRecords();
            Integer numberOfColumns = records.get(0).size();
            String[] headers = parser.getHeaderMap().keySet().toArray(new String[numberOfColumns]);

            // Put the records into a more friendly format
            for (CSVRecord record : records) {

                String buyer_name = "Chegg";

                String empStr = record.get("isbn");
                Long isbnLong = Long.parseLong(empStr);

                String locStr = record.get("quantity");
                int quantityInt = Integer.parseInt(locStr);

                String coreCompStr = record.get("price");
                int priceInt = Integer.parseInt(coreCompStr);

                Book newBook = new Book(buyer_name, isbnLong, quantityInt, priceInt);

                importedBooks.add(newBook);
            }

            System.out.print(importedBooks.get(1).getISBN());

            // flag the data as loaded, so we don't do it twice
            isDataLoaded = true;

        } catch (IOException e) {
            System.out.println("Failed to load book data");
            e.printStackTrace();
        }
    }

}
