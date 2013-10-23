package ticketmachine;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TicketMachineStateServlet
 */
public class TicketMachineState extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(true);
		Cookie stateCookie = CookieUtil.getCookieByName(
				TicketMachine.COOKIE_AND_STATE_NAME, request);

		response.setContentType("text/html");
		pw.println("<html>");
		pw.println("<head><title>Hello World</title></title>");
		pw.println("<body>");
		pw.println("<h1>Hi!</h1>");
		pw.println("<h3> Your session state is "
				+ session.getAttribute(TicketMachine.COOKIE_AND_STATE_NAME)
				+ "</h3>");
		pw.println("<br/>");
		
		if (stateCookie == null) {
			pw.println("<h3> You dont have a cookie </h3>");
		} else {
			pw.println("<h3> An your cookie state is " + stateCookie.getValue()
					+ "</h3>");
		}
		
		pw.println("</body></html>");
	}

}
