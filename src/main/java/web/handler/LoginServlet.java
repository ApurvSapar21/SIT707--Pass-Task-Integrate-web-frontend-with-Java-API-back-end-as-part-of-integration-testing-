package web.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.service.LoginService;

/**
 * HTTP end-point to handle login service.
 */
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
	throws IOException, ServletException { 
	    System.out.println("[LoginServlet] POST");

	    // Retrieve form data from request parameters
	    String username = req.getParameter("username");
	    String password = req.getParameter("passwd");
	    String dob = req.getParameter("dob");

	    System.out.println("Username/password/DOB: " + username + ", " + password + ", " + dob);
	    
//	    String loginStatus = "fail";
//	    if (LoginService.login(username, password, dob)) {
//	    	loginStatus = "success";
//	    }
	    
	    // Authenticate user using LoginService
	    boolean loginResult = LoginService.login(username, password, dob);

	    // Set response content type and retrieve PrintWriter
	    resp.setContentType("text/html");
	    PrintWriter writer = resp.getWriter();

	    // Construct HTML response dynamically based on login status
	    String htmlResponse = "<html>";
	    htmlResponse += "<head><title>" + (loginResult ? "Login successful" : "Login failed") + "</title></head>"; 
	    htmlResponse += "<h2>Login status: " + (loginResult ? "success" : "fail") + "</h2>"; 
	    htmlResponse += "</html>";

	    writer.println(htmlResponse);
	}
}