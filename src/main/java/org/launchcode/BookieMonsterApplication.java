package org.launchcode;

import org.launchcode.models.Book;
import org.launchcode.models.Runner;
import org.launchcode.models.data.BookDataImporter;
import org.launchcode.models.data.BookDataWriter;
import org.launchcode.models.data.Scraper;
import org.launchcode.models.data.apiRequester;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class BookieMonsterApplication {

//	public static void main(String[] args) {
//
//
//
//		System.out.println(" Main!!");
//
//
//
//
//		SpringApplication.run(BookieMonsterApplication.class, args);
//
//
//		//SpringApplication.run(Runner.main, args);
//
//	}

	public static void main(String[]args){


		BookDataImporter.readCsvFile("/Users/johnmilito/git/bookies-revenge/src/main/resources/book_data.csv");
		Scraper.main();

		ArrayList<Book> testList = BookDataImporter.toList();

		ArrayList<Book> firstList = BookDataImporter.toList();
		ArrayList<Book> secondList = Scraper.toList();

		firstList.addAll(secondList);
		apiRequester.urlMaker(testList);


		BookDataWriter.writeCsvFile("/Users/johnmilito/git/bookies-revenge/src/main/resources/BookFileNew.csv", apiRequester.toList());




	}

}
