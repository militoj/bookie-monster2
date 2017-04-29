package org.launchcode.models.data;


import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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

        public static void main(String[] args) {

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

            Map<String, String> params = new HashMap<String, String>();

            params.put("Service", "AWSECommerceService");
            params.put("Operation", "ItemLookup");
            params.put("AWSAccessKeyId", "AKIAIUR4GW36IFSL4Y6A");
            params.put("AssociateTag", "book05b3-20");
            params.put("ItemId", "9780030968358");
            params.put("IdType", "ISBN");
            params.put("ResponseGroup", "ItemAttributes,Offers");
            params.put("Condition", "Used");
            params.put("SearchIndex", "Books");

            requestUrl = helper.sign(params);

            System.out.println("Signed URL: \"" + requestUrl + "\"");
        }



}
