package com.yw.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yw.delegate.ReservationDelegate;
import com.yw.dto.ReservationDTO;
import com.yw.dto.TicketDTO;
import com.yw.util.ReservationException;

public class ReservationServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		ReservationDelegate delegate = null;
		SimpleDateFormat sdf = null;
		ReservationDTO dto = null;
		TicketDTO ticket = null;
		String src = null;
		String dest = null;
		String doj = null;
		String ssn = null;
		String name = null;
		String age = null;
		String outcome = null;
		boolean flag = false;

		src = request.getParameter("src");
		dest = request.getParameter("dest");
		doj = request.getParameter("doj");
		ssn = request.getParameter("ssn");
		name = request.getParameter("name");
		age = request.getParameter("age");

		sdf = new SimpleDateFormat("dd/mm/yyyy");
		try {
			dto = new ReservationDTO(src, dest, sdf.parse(doj), ssn, name,
					Integer.parseInt(age));
			delegate = new ReservationDelegate();
			ticket = delegate.bookTicket(dto);
			request.setAttribute("ticket", ticket);
			flag = true;
		} catch (NumberFormatException e) {
			flag = false;
			e.printStackTrace();
		} catch (ParseException e) {
			flag = false;
			e.printStackTrace();
		} catch (ReservationException e) {
			flag = false;
			e.printStackTrace();
		}

		if (flag) {
			outcome = "ticketdetails.jsp";
		} else {
			outcome = "error.jsp";
		}

		dispatcher = request.getRequestDispatcher(outcome);
		dispatcher.forward(request, response);

	}

}
