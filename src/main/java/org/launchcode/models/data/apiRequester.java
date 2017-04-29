package org.launchcode.models.data;

import com.jaunt.*;
import java.util.*;
import com.jaunt.Element;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;
import com.jaunt.component.*;
import org.launchcode.models.Book;



/**
 * Created by johnmilito on 4/29/17.
 */
public class apiRequester {

    public static void main(String[]args) {
        try {
            UserAgent userAgent = new UserAgent();         //create new userAgent (headless browser).
            userAgent.sendGET("http://jsonplaceholder.typicode.com/posts/1");   //send request
            System.out.println(userAgent.json);            //print the retrieved JSON object
            System.out.println("Other response data: " + userAgent.response); //response metadata, including headers.
        } catch (JauntException e) {         //if an HTTP/connection error occurs, handle JauntException.
            System.err.println(e);
        }
    }
}
