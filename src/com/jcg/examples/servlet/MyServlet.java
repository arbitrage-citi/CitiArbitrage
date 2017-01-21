package com.jcg.examples.servlet;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;

import com.jcg.examples.gfinance.JSONMapper;
import com.jcg.examples.gfinance.Stocks;
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
//   Stocks[] b=new Stocks[50];
//   Stocks[] c=new Stocks[50];
//   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //MyClass myClass = new MyClass();
		JSONMapper j=new JSONMapper();
		Stocks[] a = new Stocks[50];
		   for( int i=0; i<50; i++ )
		       a[i] = new Stocks();
		   Stocks[] b = new Stocks[50];
		   for( int l=0; l<50; l++ )
		       b[l] = new Stocks();
		   Stocks[] c = new Stocks[50];
		   for( int k=0; k<50; k++ )
		       c[k] = new Stocks();
		// a=new Stocks[50];
		// b=new Stocks[50];
		 //c=new Stocks[50];
		 //PrintWriter out=response.getWriter();
	        if (request.getParameter("button1") != null) {
	            try {
					a=j.call();
				} catch (ParseException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	           // out.println(Integer.toString(a));
	            request.setAttribute("value", a);
	        } else if (request.getParameter("button2") != null) {
	            try {
					b=j.call();
				} catch (ParseException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	           // out.println(Integer.toString(b));
	            request.setAttribute("value", b);
	            
	        } else if (request.getParameter("button3") != null) {
	            try {
					c=j.call();
				} catch (ParseException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            //out.println(Integer.toString(c));
	            request.setAttribute("value", c);
	        } else {
	            // ???
	        }
            
	        request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(request, response);
	   
	}

}
