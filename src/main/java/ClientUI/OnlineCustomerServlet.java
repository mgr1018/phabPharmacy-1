package ClientUI;

import Website.Entities.Customer;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(urlPatterns={"/onlinecust"},loadOnStartup = 1)
public class OnlineCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        //SqlSetup tables = new SqlSetup();
        //SelectProduct quantity = new SelectProduct("'4 flu'", "'Benylin'");
       // resp.getWriter().write("<html> <head> <title>CMDMC</title> </head><body> <h1>Value Accessed " + quantity.quant + "</h1> </body> </html>");
        resp.getWriter().write(req.getServletPath());
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        AccessOnlineCustomers cust_details = new AccessOnlineCustomers(reqBody);
        Customer c = new Customer(cust_details.getFirstName(), cust_details.getLastName(), cust_details.getPostcode(), cust_details.getEmail(), cust_details.getPostalAddress(), cust_details.getContactNo());
        //System.out.println(c.name);
        Gson gson = new Gson();
        String jsonString = gson.toJson(c);
        resp.setContentType("application/json");
        resp.getWriter().write(jsonString);
    }

}
