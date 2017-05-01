package org.launchcode.models.data;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.jaunt.UserAgent;
import com.jaunt.JauntException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.launchcode.models.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Node;



/**
 * Created by johnmilito on 4/29/17.
 */
public class apiRequester {


    /*
* This class shows how to make a simple authenticated call to the
* Amazon Product Advertising API.
*
* See the README.html that came with this sample for instructions on
* configuring and running the sample.
*/

        /*
         * Your AWS Access Key ID, as taken from the AWS Your Account page.
         */
        private static final String AWS_ACCESS_KEY_ID = "AKIAIUR4GW36IFSL4Y6A";

        /*
         * Your AWS Secret Key corresponding to the above ID, as taken from the AWS
         * Your Account page.
         */
        private static final String AWS_SECRET_KEY = "tPuL4eV9W+PfLQY8KjHQ/J+iR1J/kqf+WSey2psH";

        /*
         * Use the end-point according to the region you are interested in.
         */
        private static final String ENDPOINT = "webservices.amazon.com";

        public static void urlMaker(ArrayList<Book> booksToWrite) {

        /*
         * Set up the signed requests helper.
         */
            SignedRequestsHelper helper;

            try {
                helper = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }

            String requestUrl = null;

            for (Book book: booksToWrite) {

                Map<String, String> params = new HashMap<String, String>();

                params.put("Service", "AWSECommerceService");
                params.put("Operation", "ItemLookup");
                params.put("AWSAccessKeyId", "AKIAIUR4GW36IFSL4Y6A");
                params.put("AssociateTag", "book05b3-20");
                params.put("ItemId", String.valueOf(book.getISBN()));
                params.put("IdType", "ISBN");
                params.put("ResponseGroup", "ItemAttributes,Offers");
                params.put("Condition", "Used");
                params.put("SearchIndex", "Books");

                requestUrl = helper.sign(params);

                try{
                    UserAgent userAgent = new UserAgent();         //create new userAgent (headless browser).
                    userAgent.sendGET(requestUrl);   //send request
                    System.out.println(userAgent.doc.innerXML());            //print the retrieved JSON object
                    System.out.println(userAgent.doc.findFirst("LowestUsedPrice").innerXML());            //print the retrieved JSON object

                }
                catch(JauntException e){         //if an HTTP/connection error occurs, handle JauntException.
                    System.err.println(e);
                }
            }
        }


}
