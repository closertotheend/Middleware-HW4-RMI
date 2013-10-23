package ticketmachine;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TicketMachine extends HttpServlet {
	public static final String COOKIE_AND_STATE_NAME = "State";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		HttpSession session = request.getSession(true);

		Cookie stateCookie = CookieUtil.getCookieByName(COOKIE_AND_STATE_NAME,
				request);

		if (stateCookie == null) {
			stateCookie = new Cookie(COOKIE_AND_STATE_NAME,
					State.NEW.toString());
			saveCookieToUser(response, stateCookie, State.NEW);
			session.setAttribute(COOKIE_AND_STATE_NAME, stateCookie.getValue());
		} else {
			
			stateCookie.setMaxAge(120);
			response.addCookie(stateCookie);
			session.setAttribute(COOKIE_AND_STATE_NAME, stateCookie.getValue());

			// I am lazy so I will not implement state pattern
			if (session.getAttribute(COOKIE_AND_STATE_NAME).equals(
					State.NEW.toString())) {

				State paymentState = State.PAYMENT;
				session.setAttribute(COOKIE_AND_STATE_NAME,
						paymentState.toString());
				saveCookieToUser(response, stateCookie, paymentState);

			} else if (session.getAttribute(COOKIE_AND_STATE_NAME).equals(
					State.PAYMENT.toString())) {

				session.setAttribute(COOKIE_AND_STATE_NAME,
						State.COMPLETED.toString());
				saveCookieToUser(response, stateCookie, State.COMPLETED);

			} else if (session.getAttribute(COOKIE_AND_STATE_NAME).equals(
					State.COMPLETED.toString())) {

				session.invalidate();
				destroyCookie(response, stateCookie);
			}
		}

		response.setContentType("text/html");
		pw.println("<html>");
		pw.println("<head><title>Hello World</title></title>");
		pw.println("<body>");
		pw.println("<h1>Hi!</h1>");
		pw.println("<h3> Your session state is "
				+ session.getAttribute(COOKIE_AND_STATE_NAME) + "</h3>");
		pw.println("<br/>");
		pw.println("</body></html>");
	}

	private void destroyCookie(HttpServletResponse response, Cookie stateCookie) {
		stateCookie.setMaxAge(0);
		response.addCookie(stateCookie);
	}

	private void saveCookieToUser(HttpServletResponse response,
			Cookie stateCookie, State state) {
		stateCookie.setValue(state.toString());
		stateCookie.setMaxAge(120);
		response.addCookie(stateCookie);
	}
}
