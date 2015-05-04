package helloworld;

import javax.servlet.*;

import java.io.*;

import javax.servlet.http.*;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@SuppressWarnings("serial")
public class HelloWorldServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		MongoClient mongoClient = new MongoClient("localhost", 27017);

		MongoDatabase database = mongoClient.getDatabase("test");
		
		MongoCollection<Document> collection = database.getCollection("restaurants");

		PrintWriter out = res.getWriter();

		Document myDoc = collection.find().first();

		out.println(myDoc.toJson());
		
		out.close();
		
		mongoClient.close();
	}
}
