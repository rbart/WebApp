package helloworld;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class HelloWorldServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		PrintWriter out = res.getWriter();

		out.println("Hello, world!");
		out.close();
	}
}
