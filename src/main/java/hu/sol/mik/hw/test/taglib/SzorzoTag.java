package hu.sol.mik.hw.test.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SzorzoTag extends SimpleTagSupport {
	
	
	private int szam1, szam2;
	
	
	public void setSzam1(int szam1) {
		this.szam1 = szam1;
	}


	public void setSzam2(int szam2) {
		this.szam2 = szam2;
	}


	@Override
	public void doTag() throws JspException, IOException {
		
		
		JspWriter out = getJspContext().getOut();
		
		out.print("<h1>Szorzótábla</h1>");
		out.print("<table border=1 cellpadding=5>");
		out.print("<tr><th>");
		for (int i = 1; i <= szam2; i++ ) {
			out.print("<th>" + i);
		}
		for (int i = 1; i <= szam1; i++) {
			out.print("<tr align=center><th>" + i);
			for (int j = 1; j <= szam2; j++) {
				out.print("<td>" + i*j);
			}
		}
		out.print("</table>");
	}
}