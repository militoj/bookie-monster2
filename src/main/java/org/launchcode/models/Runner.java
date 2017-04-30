package org.launchcode.models;

import org.launchcode.models.data.BookDataWriter;


/**
 * Created by johnmilito on 4/30/17.
 */
public class Runner {


    public static void main(String[]args){
        BookDataWriter.writeCsvFile("BookFileNew");
    }
}
