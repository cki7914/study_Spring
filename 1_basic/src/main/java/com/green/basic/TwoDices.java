package com.green.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwoDices {
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse response) throws IOException {
		int rnd1 = (int)(Math.random() * 6) + 1;
		int rnd2 = (int)(Math.random() * 6) + 1;
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src='resources/img/dice" + rnd1 + ".png'>");
		out.println("<img src='resources/img/dice" + rnd2 + ".png'>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
