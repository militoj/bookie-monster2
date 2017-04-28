package org.launchcode.models.data;
import org.launchcode.models.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
import java.util.List;

/**
 * Created by johnmilito on 4/24/17.
 */
//Borrowed from http://stackoverflow.com/questions/30073980/java-writing-strings-to-a-csv-file
public class BookDataWriter {




        public static void main(String[]args) throws FileNotFoundException{

            PrintWriter pw = new PrintWriter(new File("/Users/johnmilito/git/bookie-monster/src/main/resources/test.csv"));
            StringBuilder sb = new StringBuilder();
            sb.append("ISBN");
            sb.append(',');
            sb.append("Quantity");
            sb.append(',');
            sb.append("Price");
            sb.append(',');
            sb.append("Date Created");
            sb.append('\n');

            sb.append("1");
            sb.append(',');
            sb.append("Prashant Ghimire");
            sb.append('\n');


            pw.write(sb.toString());
            pw.close();
            System.out.println("done!");

        }

}
