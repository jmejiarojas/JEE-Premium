package servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responsepdf")
public class ResponseServletPDF extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/pdf");
		//response.setHeader("Content-Disposition", "attachment; filename='cv.pdf'");
		
		ServletOutputStream out;
		out = response.getOutputStream();
		
		String relativeWebPath = "/WEB-INF/resources/pdf/cv.pdf";
		
		InputStream fin = getServletContext().getResourceAsStream(relativeWebPath);
		
		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		
		int ch = 0;
		
		while((ch= bin.read()) != -1){ //Hasta que ya no hay datos
			bout.write(ch); // Cada bit que vaya leyendo lo va a poner en el buffer de salida
		}
		
		bin.close();
		fin.close();
		bout.close();
		out.close();
	}
	
	
}
