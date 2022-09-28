package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.myCalc;

/**
 * Servlet implementation class CalcController
 */
@WebServlet("/calc.do")
public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 클라이언트에서 넘어오는 폼 파라미터 받기(파라미터 수집... su1, su2 >> request라는 객체에서 받는다)
		// getParameter()를 이용해서 넘어온 파라미터를 받는다.
		// String 으로 받는다.
		// Integer 로 바꿔준다
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));

		// 비지니스 로직 > Model로 분리하기
		/*
		 * int sum = 0; for (int i = su1; i <= su2; i++) { sum += i; }
		 */
		myCalc my = new myCalc();
		int sum = my.hap(su1, su2);
		
		// 2. 응답 보내기
		PrintWriter out = response.getWriter();
		out.println("total =" + sum);
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>TOTAL</td>");
		out.println("<td>");
		out.println(sum);
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
