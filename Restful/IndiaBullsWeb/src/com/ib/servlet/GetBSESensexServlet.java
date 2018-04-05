package com.ib.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ib.dto.SensexInfo;
import com.ib.invoker.StockQuoteInvoker;

@WebServlet(urlPatterns="/getBSESensex")
public class GetBSESensexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		SensexInfo sensexInfo = null;
		StockQuoteInvoker invoker = null;
		RequestDispatcher dispatcher = null;

		invoker = StockQuoteInvoker.getInstance();
		invoker.init();
		sensexInfo = invoker.getBSESensex();
		invoker.close();
		
		req.setAttribute("bseSensexInfo", sensexInfo);

		dispatcher = req.getRequestDispatcher("/bseSensex.jsp");
		dispatcher.forward(req, resp);
	}

}
