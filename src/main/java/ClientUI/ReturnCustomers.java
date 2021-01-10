package ClientUI;
import Website.Functions.CustomerListSize;

import java.util.ArrayList;

/* This class makes a post request to the AccessCustomer servlet which responds with
 * the details of that online customer from the database. Logs beginning with RD come
 * from this class */

public class ReturnCustomers {

    public ArrayList<ReturnCustomer> custs = new ArrayList<ReturnCustomer>();

    public ReturnCustomers (){
        CustomerListSize s = new CustomerListSize();
        for (int i=1; i<=s.getSize() ; i++){
            ReturnCustomer c = new ReturnCustomer(i);
            custs.add(c);
        }
    }

}
